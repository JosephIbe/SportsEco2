package in.sashi.sporteco.ui.fragments.shared_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.elyeproj.loaderviewlibrary.LoaderTextView;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.CoachDetails;
import in.sashi.sporteco.models.app.Players;
import in.sashi.sporteco.models.app.Players_Table;
import in.sashi.sporteco.utils.AppUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicInfoFragment extends Fragment {

    private static final String TAG = BasicInfoFragment.class.getSimpleName();

    private LoaderTextView nameTV, emailTV, addressTV, phoneTV, stateTV;
    private LinearLayout nameLayout;

    private CoachDetails query;
    private Players players;

    private boolean fromCoach = false, fromPlayers = false;
    private String playerId = null;

    public BasicInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic_info, container, false);
        initViews(view);

        fromCoach = getArguments().getBoolean("from_coach");
        fromPlayers = getArguments().getBoolean("from_players");
        playerId = getArguments().getString("player_id");

        Log.d(TAG, "From Coach:\t" + fromCoach);
        Log.d(TAG, "From Players:\t" + fromPlayers);
        Log.d(TAG, "PId:\t" + playerId);

        return view;
    }

    private void initViews(View view) {
        nameTV = view.findViewById(R.id.nameTV);
        nameLayout = view.findViewById(R.id.nameLayout);
        emailTV = view.findViewById(R.id.emailTV);
        addressTV = view.findViewById(R.id.addressTV);
        phoneTV = view.findViewById(R.id.phoneTV);
        stateTV = view.findViewById(R.id.stateTV);

        populate();

    }

    private void populate() {

        if (fromCoach) {

            //        query = SQLite.select()
//                .from(CoachDetails.class)
//                .where(CoachDetails_Table.coachId.is(AppUtils.getCoachId()))
//                .querySingle();

//        query = new Select()
//                .from(CoachDetails.class)
//                .where(CoachDetails_Table.coachId.is(AppUtils.getCoachId()))
//                .querySingle();

            query = SQLite.select()
                    .from(CoachDetails.class)
                    .querySingle();

            Log.d(TAG, "Cid profile:\t" + AppUtils.getCoachId());
            Log.d(TAG, "CEmail:\t" + query.getEmailAddr());

            nameLayout.setVisibility(View.GONE);
            emailTV.setText(query.username);
            phoneTV.setText(query.getMobileNum());
            addressTV.setText(query.getAddress());
            stateTV.setText(query.getOriginState());
        } else if (fromPlayers){

            players = SQLite.select()
                    .from(Players.class)
                    .where(Players_Table.userId.is(playerId))
                    .querySingle();

            nameLayout.setVisibility(View.VISIBLE);
            nameTV.setText(players.getFirstName() + " " + players.getLastName());
            emailTV.setText(players.getUsername());
            phoneTV.setText(players.getMobilePlayer());
            addressTV.setText(players.getAddress());
            stateTV.setText(players.getStatePlayer());

        }

    }

}
