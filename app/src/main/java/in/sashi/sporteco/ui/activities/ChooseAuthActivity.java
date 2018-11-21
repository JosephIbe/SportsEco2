package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class ChooseAuthActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ChooseAuthActivity.class.getSimpleName();

    private TextView loginTV, registerTV;
    private Button fbBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_auth);

        init();

        loginTV.setOnClickListener(this);
        registerTV.setOnClickListener(this);
        fbBtn.setOnClickListener(this);

    }

    private void init() {
        fbBtn = findViewById(R.id.fbBtn);
        loginTV = findViewById(R.id.loginTV);
        registerTV = findViewById(R.id.registerTV);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginTV:
                startActivity(new Intent(ChooseAuthActivity.this, LoginActivity.class));
                break;
            case R.id.registerTV:
                //do ntn now
                break;
            case R.id.fbBtn:
                Snackbar.make(findViewById(android.R.id.content), "Coming Soon", Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}
