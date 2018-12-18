package in.sashi.sporteco.ui.fragments.players;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;
import in.sashi.sporteco.ui.fragments.shared_fragments.BasicInfoFragment;
import in.sashi.sporteco.ui.fragments.shared_fragments.CoachInfoFragment;
import in.sashi.sporteco.ui.fragments.shared_fragments.PhysicalInfoFragment;

import static in.sashi.sporteco.utils.Constants.PLAYER_KEY_IMAGE_URL;

public class PlayerInfoFragment extends BottomSheetDialogFragment {

    private static final String TAG = PlayerInfoFragment.class.getSimpleName();

    private CircleImageView infoCIV;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.PlayerInfoDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_info, container, false);

        init(view);

        setUpTabs();

        return view;
    }

    private void init(View view) {
        infoCIV = view.findViewById(R.id.infoCIV);
        tabLayout = view.findViewById(R.id.playerTabs);
        viewPager = view.findViewById(R.id.playerVP);

        String imgURL = getArguments().getString(PLAYER_KEY_IMAGE_URL);

        Picasso.with(getActivity())
                .load(imgURL)
                .placeholder(R.drawable.app_logo_resized)
                .into(infoCIV);

    }

    private void setUpTabs() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        BasicInfoFragment bif = new BasicInfoFragment();
        CoachInfoFragment cif = new CoachInfoFragment();
        PhysicalInfoFragment pif = new PhysicalInfoFragment();

        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragTab(bif, "Basic Info");
        pagerAdapter.addFragTab(pif, "Physical Info");
        pagerAdapter.addFragTab(cif, "CoachDetails Info");
        viewPager.setAdapter(pagerAdapter);
    }

}
