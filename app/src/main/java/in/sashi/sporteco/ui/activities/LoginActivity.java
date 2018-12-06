package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Batch;
import in.sashi.sporteco.models.app.Coach;
import in.sashi.sporteco.utils.Constants;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText etUsername, etPwd;
    private TextView forgotTV;
    private Button loginBtn;

    private Coach coach;
    private Batch batch;

    private boolean hasBatch = false;
    private String username, pwd, coach_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        forgotTV.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

    }

    private void init() {
        etPwd = findViewById(R.id.etPwd);
        etUsername = findViewById(R.id.etUsername);
        forgotTV = findViewById(R.id.forgotTV);
        loginBtn = findViewById(R.id.loginBtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                // add validation later;
                username = etUsername.getText().toString();
                pwd = etPwd.getText().toString();
                doLogin(username, pwd);
                break;
            case R.id.forgotTV:
                Snackbar.make(findViewById(android.R.id.content), "Coming Soon", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    private void doLogin(String email, String pwd) {

        JSONObject jsonObject = new JSONObject();
        try {
//            jsonObject.put("username", email);
//            jsonObject.put("password", pwd);
            jsonObject.put("username", "testcoach@gmail.com");
            jsonObject.put("password", "123@abcd");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.LOGIN_COACH)
                .addJSONObjectBody(jsonObject)
                .setTag("Coach Login")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {

                            Log.d(TAG, "Login Resp:\t" + response.toString());

                            try {
                                JSONObject object = new JSONObject(response.toString());
                                JSONObject details = object.getJSONObject("coach_details");

                                coach_id = details.getString("coach_id");

                                String academyId = details.getString("academy_id");
                                String username = details.getString("username");
                                String firstName = details.getString("first_name");
                                String lastName = details.getString("last_name");
                                String midName = details.getString("middle_name");
                                String nick = details.getString("nick_name");
                                String gender = details.getString("gender");
                                String mobile = details.getString("mobile");
                                String state = details.getString("state");
                                String email_coach = details.getString("email");

                                // Save in db
                                saveCoachDetails(coach_id, academyId, username, firstName, lastName, midName, nick, gender, mobile, state, email_coach);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    private void saveCoachDetails(String idCoach, String academyId, String username, String firstName, String lastName, String midName, String nick, String gender, String mobile, String state, String email) {

        coach = new Coach();
        coach.setCoachId(idCoach);
        coach.setAcademyId(academyId);
        coach.setUsername(username);
        coach.setEmailAddr(email);
        coach.setFirstName(firstName);
        coach.setLastName(lastName);
        coach.setMidName(midName);
        coach.setNickName(nick);
        coach.setGender(gender);
        coach.setMobileNum(mobile);
        coach.setOriginState(state);

        coach.save();

        Coach coachQuery = new Select()
                .from(Coach.class)
                .where("coach_id=?", coach_id)
                .executeSingle();
        Log.d(TAG, "Coach id:\t" + coachQuery.coachId);
        coach_id = coachQuery.coachId;

        getAllData(coach_id);


    }

    private void getAllData(String coach_id) {

        Log.d(TAG, "Getting Data");

        JSONObject data = new JSONObject();
        try {
            data.put("coach_id", coach_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.GET_ALL_DATA)
                .setTag("Get Coach Meta")
                .setPriority(Priority.HIGH)
                .addJSONObjectBody(data)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null){
                            Log.d(TAG, "GAD:\t" + response.toString());
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, anError.getErrorDetail());
                    }
                });

    }

}
