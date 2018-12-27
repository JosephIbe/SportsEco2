package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.raizlabs.android.dbflow.config.FlowManager;

import in.sashi.sporteco.R;
import in.sashi.sporteco.rest.db.SportsDatabase;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, ChooseAuthActivity.class));
                finish();
            }
        }, 4000);

        FlowManager.getDatabase(SportsDatabase.class).destroy(this);

    }
}
