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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Batch;
import in.sashi.sporteco.models.app.Coach;
import in.sashi.sporteco.rest.RestClient;
import in.sashi.sporteco.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText etUsername, etPwd;
    private TextView forgotTV;
    private Button loginBtn;

    private Coach coach;
    private Batch batch;

    private boolean isEnabled = true;
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
                Snackbar.make(findViewById(android.R.id.content), "Login Clicked", Snackbar.LENGTH_LONG).show();
                // add validation later;
                username = etUsername.getText().toString();
                pwd = etPwd.getText().toString();
//                doLogin(username, pwd);
                attemptogin(username, pwd);
                loginBtn.setEnabled(false);
                break;
            case R.id.forgotTV:
                Snackbar.make(findViewById(android.R.id.content), "Coming Soon", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    private void attemptogin(String username, String pwd) {
        Call<Coach> call = RestClient.getRestInstance()
                .getLoginService()
                .loginCoach("testcoach@gmail.com", "123@abcd"); // TODO: 12/17/2018 Use input values

        call.enqueue(new Callback<Coach>() {
            @Override
            public void onResponse(Call<Coach> call, Response<Coach> response) {
                if (response != null && response.code() == 200){
                    Log.d(TAG, "Login Response:\t" + response.toString());
                    Log.d(TAG, "Login Response:\t" + response.body());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Snackbar.make(findViewById(android.R.id.content), "Login Failed with Error Code:\t" + response.code(),
                            Snackbar.LENGTH_LONG).show();
                    loginBtn.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<Coach> call, Throwable t) {
                Snackbar.make(findViewById(android.R.id.content), "Unable to Login...Check Your Connection or Credentials",
                        Snackbar.LENGTH_LONG).show();
            }
        });
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
                        Snackbar.make(findViewById(android.R.id.content), "Waiting for Response", Snackbar.LENGTH_LONG).show();
                        if (response != null) {

                            Snackbar.make(findViewById(android.R.id.content), "Got Response", Snackbar.LENGTH_LONG).show();

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
//                                saveCoachDetails(coach_id, academyId, username, firstName, lastName, midName, nick, gender, mobile, state, email_coach);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, anError.getErrorDetail());
                    }
                });
    }

//    private void saveCoachDetails(String idCoach, String academyId, String username, String firstName, String lastName, String midName, String nick, String gender, String mobile, String state, String email) {
//
//        Snackbar.make(findViewById(android.R.id.content), "Saving Coach Bio", Snackbar.LENGTH_LONG).show();
//
//        coach = new Coach();
//        coach.setCoachId(idCoach);
//        coach.setAcademyId(academyId);
//        coach.setUsername(username);
//        coach.setEmailAddr(email);
//        coach.setFirstName(firstName);
//        coach.setLastName(lastName);
//        coach.setMidName(midName);
//        coach.setNickName(nick);
//        coach.setGender(gender);
//        coach.setMobileNum(mobile);
//        coach.setOriginState(state);
//
//        coach.save();
//        Snackbar.make(findViewById(android.R.id.content), "Save Complete", Snackbar.LENGTH_LONG).show();
//
//        Coach coachQuery = new Select()
//                .from(Coach.class)
//                .where("coach_id=?", coach_id)
//                .executeSingle();
//        Log.d(TAG, "Coach id:\t" + coachQuery.coachId);
//        coach_id = coachQuery.coachId;
//
//        getAllData(coach_id);
//
//
//    }

    private void getAllData(String coach_id) {

        Snackbar.make(findViewById(android.R.id.content), "Getting All Data", Snackbar.LENGTH_LONG).show();

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
