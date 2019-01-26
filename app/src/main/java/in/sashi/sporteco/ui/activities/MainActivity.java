package in.sashi.sporteco.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import in.sashi.sporteco.R;
import in.sashi.sporteco.ui.fragments.AlertsFragment;
import in.sashi.sporteco.ui.fragments.HomeFragment;
import in.sashi.sporteco.ui.fragments.MessagesFragment;
import in.sashi.sporteco.ui.fragments.ProfileFragment;
import in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.NewBatchDialog;
import in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.NewPlayerDialog;
import in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs.NewProgramDialog;
import in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.NewScheduleDialog;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Toolbar toolbar;
    private BottomNavigationViewEx navEx;

    private Fragment fragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void switchFragment(Fragment fragment) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragHolder, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void init() {
        navEx = findViewById(R.id.navEx);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragment = new HomeFragment();
        switchFragment(fragment);

        navEx.enableAnimation(true);
        navEx.enableShiftingMode(false);

        int centerPos = 2;
        navEx.setIconSizeAt(centerPos, 50, 40);

        navEx.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.ACTION_DOWN) {
            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                fragment = new HomeFragment();
                switchFragment(fragment);
                return true;
            case R.id.nav_explore:
                fragment = new AlertsFragment();
                switchFragment(fragment);
                return true;
            case R.id.nav_add:
                // show popup window
                View view = getLayoutInflater().inflate(R.layout.add_dialog_layout, null);
                PopupWindow window = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT, true);
                window.setOutsideTouchable(true);

                LinearLayout addSchedule = window.getContentView().findViewById(R.id.addSchedule);
                addSchedule.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewScheduleDialog scheduleDialog = new NewScheduleDialog();
                        scheduleDialog.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                        scheduleDialog.show(getSupportFragmentManager(), "NewScheduleDialog");
                    }
                });

                LinearLayout addPlayer = window.getContentView().findViewById(R.id.addPlayer);
                addPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewPlayerDialog playerDialog = new NewPlayerDialog();
                        playerDialog.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                        playerDialog.show(getSupportFragmentManager(), "NewPlayerDialog");
                    }
                });

                LinearLayout addProgram = window.getContentView().findViewById(R.id.addProgram);
                addProgram.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewProgramDialog programDialog = new NewProgramDialog();
                        programDialog.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                        programDialog.show(getSupportFragmentManager(), "NewProgramDialog");
                    }
                });

                LinearLayout addBatch = window.getContentView().findViewById(R.id.addBatch);
                addBatch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewBatchDialog batchDialog = new NewBatchDialog();
                        batchDialog.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                        batchDialog.show(getSupportFragmentManager(), "NewBatchDialog");
                    }
                });

//                window.showAtLocation(navEx, Gravity.BOTTOM, 0, 120);
                window.showAtLocation(navEx, Gravity.BOTTOM, 0, navEx.getItemHeight() - 3);
                break;
            case R.id.nav_messages:
                fragment = new MessagesFragment();
                switchFragment(fragment);
                return true;
            case R.id.nav_profile:
                fragment = new ProfileFragment();
                switchFragment(fragment);
                return true;
        }
        return false;
    }
}
