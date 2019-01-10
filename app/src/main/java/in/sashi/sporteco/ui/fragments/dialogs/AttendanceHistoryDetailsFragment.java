package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;
import in.sashi.sporteco.ui.fragments.attendance.AbsentFragment;
import in.sashi.sporteco.ui.fragments.attendance.PresentFragment;

public class AttendanceHistoryDetailsFragment extends DialogFragment {

    private static final String TAG = AttendanceHistoryDetailsFragment.class.getSimpleName();

    public static final String KEY_SESSION_NAME = "session_name";
    public static final String KEY_PRESENT = "players_present";
    public static final String KEY_TOTAL = "total_players";

    private Toolbar toolbar;
    private ImageView closeIV;
    private TextView detailsNameTV;

    private TabLayout historyTabs;
    private ViewPager viewPager;

    private ViewPagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance_history_details, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        detailsNameTV = view.findViewById(R.id.detailsNameTV);
        historyTabs = view.findViewById(R.id.historyTabs);
        viewPager = view.findViewById(R.id.viewPager);

        String title = getArguments().getString(KEY_SESSION_NAME);
        String presentCount = getArguments().getString(KEY_PRESENT);
        String totalCount = getArguments().getString(KEY_TOTAL);

        int absent = Integer.parseInt(totalCount) - Integer.parseInt(presentCount);
        String absentCount = absent + "";

        detailsNameTV.setText(title);

        setUpTabs(presentCount, absentCount);

        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    private void setUpTabs(String presentCount, String absentCount) {
        historyTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        historyTabs.setupWithViewPager(viewPager);
        setUpViewPager(viewPager, presentCount, absentCount);
    }

    private void setUpViewPager(ViewPager viewPager, String presentCount, String absentCount) {

        AbsentFragment af = new AbsentFragment();
        PresentFragment pf = new PresentFragment();

        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragTab(af, "Present " + presentCount);
        pagerAdapter.addFragTab(pf, "Absent " + absentCount);
        viewPager.setAdapter(pagerAdapter);
    }

}
