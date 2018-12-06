package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;
import in.sashi.sporteco.ui.fragments.dialogs.EvalFilterSessionFragment;
import in.sashi.sporteco.ui.fragments.evaluate.EvalSessionsFragment;
import in.sashi.sporteco.ui.fragments.evaluate.EvalSkillsFragment;
import in.sashi.sporteco.ui.fragments.evaluate.EvalBatchFragment;

public class EvaluateActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = EvaluateActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV, filterIV, clockIV;
    private TabLayout filterTabs;
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        init();

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        backIV = findViewById(R.id.backIV);
        filterIV = findViewById(R.id.filterIV);
        clockIV = findViewById(R.id.clockIV);
        filterTabs = findViewById(R.id.filterTabs);
        viewPager = findViewById(R.id.evalVP);

        setSupportActionBar(toolbar);

        setUpTabs();

        backIV.setOnClickListener(this);
        filterIV.setOnClickListener(this);
        clockIV.setOnClickListener(this);

    }

    private void setUpTabs() {
        filterTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        filterTabs.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        EvalSessionsFragment esf = new EvalSessionsFragment();
        EvalBatchFragment bef = new EvalBatchFragment();
        EvalSkillsFragment sef = new EvalSkillsFragment();

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragTab(esf, "Sessions");
        pagerAdapter.addFragTab(bef, "Batch");
        pagerAdapter.addFragTab(sef, "Skills");
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backIV:
                startActivity(new Intent(EvaluateActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.filterIV:
                showFiltersDialog();
                break;
            case R.id.clockIV:
                Snackbar.make(findViewById(android.R.id.content), "What Next?", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    private void showFiltersDialog() {
        EvalFilterSessionFragment fragment = new EvalFilterSessionFragment();
        fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar);
        fragment.setCancelable(true);
        fragment.show(getSupportFragmentManager(), "EvalFilterSessionFragment");
    }

}
