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
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONException;
import org.json.JSONObject;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Batch;
import in.sashi.sporteco.models.app.Coach;
import in.sashi.sporteco.models.app.CoachDetails;
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
//                Snackbar.make(findViewById(android.R.id.content), "Login Clicked", Snackbar.LENGTH_LONG).show();
                // add validation later;
                username = etUsername.getText().toString();
                pwd = etPwd.getText().toString();
//                doLogin(username, pwd);
                attemptLogin(username, pwd);
                loginBtn.setEnabled(false);
                break;
            case R.id.forgotTV:
                Snackbar.make(findViewById(android.R.id.content), "Coming Soon", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    private void attemptLogin(String username, String pwd) {
        Call<Coach> call = RestClient.getRestInstance()
                .getLoginService()
                .loginCoach("testcoach@gmail.com", "123@abcd"); // TODO: 12/17/2018 Use input values

        call.enqueue(new Callback<Coach>() {
            @Override
            public void onResponse(Call<Coach> call, Response<Coach> response) {
                if (response.isSuccessful()) {

                    Coach coach = response.body();

                    coach_id = coach.getCoachDetails().getCoachId();
                    String acadId = coach.getCoachDetails().getAcademyId();
                    String username = coach.getCoachDetails().getUsername();
                    String first = coach.getCoachDetails().getFirstName();
                    String last = coach.getCoachDetails().getLastName();
                    String gender = coach.getCoachDetails().getGender();
                    String mobile = coach.getCoachDetails().getMobileNum();
                    String email = coach.getCoachDetails().getEmailAddr();
                    String mid_name = coach.getCoachDetails().getMidName();
                    String nick = coach.getCoachDetails().getNickName();
                    String state = coach.getCoachDetails().getOriginState();

                    CoachDetails coachDetails = new CoachDetails();
                    coachDetails.setCoachId(coach_id);
                    coachDetails.setAcademyId(acadId);
                    coachDetails.setFirstName(first);
                    coachDetails.setLastName(last);
                    coachDetails.setGender(gender);
                    coachDetails.setMobileNum(mobile);
                    coachDetails.setEmailAddr(email);
                    coachDetails.setMidName(mid_name);
                    coachDetails.setNickName(nick);
                    coachDetails.setUsername(username);
                    coachDetails.setOriginState(state);
                    coachDetails.save();

                    CoachDetails details = SQLite.select()
                            .from(CoachDetails.class)
                            .querySingle();

                    coach_id = details.getCoachId();
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
                Log.d(TAG, "Error:\t" + t.getMessage());
                loginBtn.setEnabled(true);
            }
        });
    }

}
