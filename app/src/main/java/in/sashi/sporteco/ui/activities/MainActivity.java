package in.sashi.sporteco.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import in.sashi.sporteco.R;
import in.sashi.sporteco.TestDialog;
import in.sashi.sporteco.ui.fragments.AddFragment;
import in.sashi.sporteco.ui.fragments.AlertsFragment;
import in.sashi.sporteco.ui.fragments.MessagesFragment;
import in.sashi.sporteco.ui.fragments.HomeFragment;
import in.sashi.sporteco.ui.fragments.ProfileFragment;

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
                fragment = new AddFragment();
                switchFragment(fragment);
                return true;

//                TestDialog dialog = new TestDialog();
//                dialog.show();

//                Window window = dialog.getWindow();
//                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

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
