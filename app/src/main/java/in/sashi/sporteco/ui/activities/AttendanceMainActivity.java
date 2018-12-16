package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;
import in.sashi.sporteco.ui.fragments.AttendanceHistoryFragment;
import in.sashi.sporteco.ui.fragments.UpComingFragment;

public class AttendanceMainActivity extends AppCompatActivity {

    private static final String TAG = AttendanceMainActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        init();

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AttendanceMainActivity.this, MainActivity.class));
                finish();
            }
        });

        setUpTabs();

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        backIV = findViewById(R.id.backIV);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);

    }

    private void setUpTabs() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        UpComingFragment uf = new UpComingFragment();
        AttendanceHistoryFragment ahf = new AttendanceHistoryFragment();

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragTab(uf, "UpComing Sessions");
        pagerAdapter.addFragTab(ahf, "Attendance History");
        viewPager.setAdapter(pagerAdapter);
    }

}
