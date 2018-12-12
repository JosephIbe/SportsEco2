package in.sashi.sporteco.ui.fragments.evaluate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;

public class EvaluateSessionDetailFragment extends DialogFragment implements View.OnClickListener {

    private static final String TAG = EvaluateSessionDetailFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;
    private RadioGroup playersGroup;
    private TextView session_detail_nameTV, detail_player_nameTV;
    private TabLayout sessionDetailsTabs;
    private ViewPager detailsVP;
    private ViewPagerAdapter pagerAdapter;
    private Button doneBtn;
    private LinearLayout rootLayout_session;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evaluate_session_detail, container, false);

        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        playersGroup = view.findViewById(R.id.playersGroup);
        session_detail_nameTV = view.findViewById(R.id.session_detail_nameTV);
        detail_player_nameTV = view.findViewById(R.id.detail_player_nameTV);
        detailsVP = view.findViewById(R.id.detailsVP);
        sessionDetailsTabs = view.findViewById(R.id.sessionDetailsTabs);
        doneBtn = view.findViewById(R.id.doneBtn);
        rootLayout_session = view.findViewById(R.id.rootLayout_session);

        Log.d(TAG, "Name:\t" + getArguments().getString("name_session"));
        String name = getArguments().getString("name_session");
        session_detail_nameTV.setText(name);

        setUpTabs();

        closeIV.setOnClickListener(this);
        doneBtn.setOnClickListener(this);

    }

    private void setUpTabs() {
        sessionDetailsTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        sessionDetailsTabs.setupWithViewPager(detailsVP);
        setUpViewPager(detailsVP);
    }

    private void setUpViewPager(ViewPager viewPager) {

        DrillsBasedFragment dbf = new DrillsBasedFragment();
        SessionsBasedFragment sbf = new SessionsBasedFragment();

        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragTab(dbf, "Based on Drills");
        pagerAdapter.addFragTab(sbf, "Based on Session");
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.closeIV:
                dismiss();
                break;
            case R.id.doneBtn:
                Snackbar.make(rootLayout_session, "What next???", Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}
