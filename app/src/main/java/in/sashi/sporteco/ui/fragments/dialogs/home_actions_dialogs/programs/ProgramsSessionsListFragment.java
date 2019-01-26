package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;
import in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs.tabs.MySessionsFragment;
import in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs.tabs.RecommFragment;

public class ProgramsSessionsListFragment extends DialogFragment {

    private Toolbar toolbar;
    private ImageView closeIV;
    private TabLayout tabLayout;
    private FloatingActionButton addSessionFAB;
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sessions_list, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        tabLayout = view.findViewById(R.id.tabLayout);
        addSessionFAB = view.findViewById(R.id.addSessionFAB);
        viewPager = view.findViewById(R.id.viewPager);

        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        addSessionFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewSessionDialog sessionDialog = new NewSessionDialog();
                sessionDialog.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                sessionDialog.show(getChildFragmentManager(), "NewSessionDialog");
            }
        });

        setUpTabs();
    }

    private void setUpTabs() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        MySessionsFragment mf = new MySessionsFragment();
        RecommFragment rf = new RecommFragment();

        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragTab(mf, "My Sessions");
        pagerAdapter.addFragTab(rf, "Recommended");
        viewPager.setAdapter(pagerAdapter);
    }

}
