package in.sashi.sporteco.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;
import in.sashi.sporteco.ui.activities.MainActivity;
import in.sashi.sporteco.ui.fragments.shared_fragments.BasicInfoFragment;
import in.sashi.sporteco.ui.fragments.shared_fragments.CoachInfoFragment;
import in.sashi.sporteco.ui.fragments.shared_fragments.PhysicalInfoFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private CircleImageView profileCIV;
    private TextView coachNameTV, numProgramsTV, numPlayersTV, numBatchesTV;

    private TabLayout coachTabs;
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        backIV = view.findViewById(R.id.backIV);
        profileCIV = view.findViewById(R.id.profileCIV);
        coachNameTV = view.findViewById(R.id.coachNameTV);
        numProgramsTV = view.findViewById(R.id.numProgramsTV);
        numPlayersTV = view.findViewById(R.id.numPlayersTV);
        numBatchesTV = view.findViewById(R.id.numBatchesTV);
        coachTabs = view.findViewById(R.id.coachTabs);
        viewPager = view.findViewById(R.id.viewPager);

        coachNameTV.setText("John Doe");
        numProgramsTV.setText("3");
        numPlayersTV.setText("89");
        numBatchesTV.setText("21");

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        setUpTabs();

    }

    private void setUpTabs() {
        coachTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        coachTabs.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        BasicInfoFragment bif = new BasicInfoFragment();
        PhysicalInfoFragment pif = new PhysicalInfoFragment();
        CoachInfoFragment cif = new CoachInfoFragment();

        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragTab(bif, "Basic Info");
        pagerAdapter.addFragTab(pif, "Physical Info");
        pagerAdapter.addFragTab(cif, "Coach Info");
        viewPager.setAdapter(pagerAdapter);
    }

}
