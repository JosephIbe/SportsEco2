package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.raizlabs.android.dbflow.config.FlowManager;

import in.sashi.sporteco.R;
import in.sashi.sporteco.rest.db.SportsDatabase;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.PrefsUtils;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        isLoggedIn = new PrefsUtils(this).getLoginStatus();
        Log.d(TAG, "Login Status:\t" + isLoggedIn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLoggedIn){
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, ChooseAuthActivity.class));
                    finish();
                }
            }
        }, 4000);

//        FlowManager.getDatabase(SportsDatabase.class).destroy(this);

    }
}
