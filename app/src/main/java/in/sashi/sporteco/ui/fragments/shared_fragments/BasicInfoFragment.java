package in.sashi.sporteco.ui.fragments.shared_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.elyeproj.loaderviewlibrary.LoaderTextView;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.coach.CoachDetails;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.models.players.Players_Table;
import in.sashi.sporteco.utils.AppUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicInfoFragment extends Fragment {

    private static final String TAG = BasicInfoFragment.class.getSimpleName();

    private LoaderTextView nameTV, emailTV, addressTV, phoneTV, stateTV;
    private LinearLayout nameLayout;

//    private CoachDetails query;

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

            SQLite.select()
                    .from(CoachDetails.class)
                    .async()
                    .querySingleResultCallback(new QueryTransaction.QueryResultSingleCallback<CoachDetails>() {
                        @Override
                        public void onSingleQueryResult(QueryTransaction transaction, @Nullable CoachDetails mQuery) {
                            setCoachBasicInfo(mQuery);
                        }
                    }).execute();

        } else if (fromPlayers) {

            nameLayout.setVisibility(View.VISIBLE);

            SQLite.select()
                    .from(Players.class)
                    .where(Players_Table.userId.is(playerId))
                    .async()
                    .querySingleResultCallback(new QueryTransaction.QueryResultSingleCallback<Players>() {
                        @Override
                        public void onSingleQueryResult(QueryTransaction transaction, @Nullable Players players) {
                            setPlayerBasicDetails(players);
                        }
                    }).execute();

        }

    }

    private void setCoachBasicInfo(CoachDetails mQuery) {
        nameLayout.setVisibility(View.GONE);
        emailTV.setText(mQuery.username);
        phoneTV.setText(mQuery.mobileNum);
        addressTV.setText(mQuery.address);
        stateTV.setText(mQuery.originState);
    }

    private void setPlayerBasicDetails(Players players) {
        nameTV.setText(players.getFirstName() + " " + players.getLastName());
        emailTV.setText(players.getUsername());
        phoneTV.setText(players.getMobilePlayer());
        addressTV.setText(players.getAddress());
        stateTV.setText(players.getStatePlayer());
    }

}
