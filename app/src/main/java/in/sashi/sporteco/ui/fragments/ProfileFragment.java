package in.sashi.sporteco.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;
import in.sashi.sporteco.models.app.Coach;
import in.sashi.sporteco.models.app.CoachDetails;
import in.sashi.sporteco.models.app.CoachDetails_Table;
import in.sashi.sporteco.ui.activities.MainActivity;
import in.sashi.sporteco.ui.fragments.shared_fragments.BasicInfoFragment;
import in.sashi.sporteco.ui.fragments.shared_fragments.CoachInfoFragment;
import in.sashi.sporteco.ui.fragments.shared_fragments.PhysicalInfoFragment;
import in.sashi.sporteco.utils.AppUtils;

import static in.sashi.sporteco.utils.Constants.BASE_URL;

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
    private CoachDetails coach, query;

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

        query = new Select()
                .from(CoachDetails.class)
                .where(CoachDetails_Table.coachId.is(AppUtils.getCoachId()))
                .querySingle();

        coachNameTV.setText(query.getFirstName() + " " + query.getLastName());

        populate();

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        setUpTabs();

    }

    private void populate() {
        final String coachId = AppUtils.getCoachId();
        JSONObject object = new JSONObject();
        try {
            object.put("coach_id", coachId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(BASE_URL + "coach_profile_screen")
                .addJSONObjectBody(object)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject details = jsonObject.getJSONObject("coach_details");

//                            coach = new CoachDetails();
                            coach = new SQLite().select()
                                    .from(CoachDetails.class)
                                    .querySingle();

                            coach.setFirstName(details.getString("first_name"));
                            coach.setLastName(details.getString("last_name"));
                            coach.setNickName(details.getString("nick_name"));
                            coach.setGender(details.getString("gender"));
                            coach.setUsername(details.getString("username"));
                            coach.setEmailAddr(details.getString("email"));
                            coach.setMobileNum(details.getString("mobile"));
                            coach.setAddress(details.getString("address"));
                            coach.setProgramsCount(details.getString("program_count"));
                            coach.setPlayersCount(details.getString("player_count"));
                            coach.setBatchCount(details.getString("batch_count"));
                            coach.setImageURL(details.getString("image"));

                            coach.update();

                            Picasso.with(getActivity())
                                    .load(coach.getImageURL())
                                    .placeholder(R.drawable.app_logo_resized)
                                    .into(profileCIV);

                            numProgramsTV.setText(coach.getProgramsCount());
                            numPlayersTV.setText(coach.getPlayersCount());
                            numBatchesTV.setText(coach.getBatchCount());


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    private void setUpTabs() {
        coachTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        coachTabs.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        Bundle coachBundle = new Bundle();
        coachBundle.putBoolean("from_coach", true);

        BasicInfoFragment bif = new BasicInfoFragment();
        bif.setArguments(coachBundle);

        PhysicalInfoFragment pif = new PhysicalInfoFragment();
        pif.setArguments(coachBundle);

        CoachInfoFragment cif = new CoachInfoFragment();
        cif.setArguments(coachBundle);

        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragTab(bif, "Basic Info");
        pagerAdapter.addFragTab(pif, "Physical Info");
        pagerAdapter.addFragTab(cif, "Coach Info");
        viewPager.setAdapter(pagerAdapter);
    }

}
