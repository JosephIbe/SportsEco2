package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import in.sashi.sporteco.R;
import in.sashi.sporteco.ui.fragments.dialogs.MarkAttendanceFragment;
import in.sashi.sporteco.ui.fragments.dialogs.StartSessionDialogFragment;
import in.sashi.sporteco.utils.Constants;

public class ViewSessionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ViewSessionActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private TextView nameSessTV, sessDescTV;
    private Button attendanceBtn, startBtn, addPlayerBtn;

    private RecyclerView focusRV, equipmentsRV;
    private String session_name, session_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_session);

        session_name = getIntent().getExtras().getString(Constants.SESSION_NAME_KEY);
        session_id = getIntent().getExtras().getString(Constants.SESSION_ID_KEY);

        init();
        setSupportActionBar(toolbar);

        nameSessTV.setText(session_name);

        backIV.setOnClickListener(this);
        attendanceBtn.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        addPlayerBtn.setOnClickListener(this);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        backIV = findViewById(R.id.backIV);
        nameSessTV = findViewById(R.id.nameSessTV);
        sessDescTV = findViewById(R.id.sessDescTV);
        attendanceBtn = findViewById(R.id.attendanceBtn);
        startBtn = findViewById(R.id.startBtn);
        addPlayerBtn = findViewById(R.id.addPlayerBtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                startActivity(new Intent(ViewSessionActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.attendanceBtn:
                MarkAttendanceFragment fragment = new MarkAttendanceFragment();
                fragment.setCancelable(true);
                fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
                fragment.show(getSupportFragmentManager(), "MarkAttendanceFragment");
                break;
            case R.id.startBtn:
                StartSessionDialogFragment sessionDialogFragment = new StartSessionDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.SESSION_NAME_KEY, session_name);
                bundle.putString(Constants.SESSION_ID_KEY, session_id);
                sessionDialogFragment.setArguments(bundle);
                sessionDialogFragment.setCancelable(false);
                sessionDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
                sessionDialogFragment.show(getSupportFragmentManager(), "StartSessionDialogFragment");
                break;
            case R.id.addPlayerBtn:
                Snackbar.make(findViewById(android.R.id.content), "What View?", Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}