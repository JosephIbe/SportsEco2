package in.sashi.sporteco.ui.fragments.evaluate;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.SkillsAdapter;
import in.sashi.sporteco.adapters.SkillsPlayersAdapter;
import in.sashi.sporteco.models.app.Skills;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvalSkillsFragment extends Fragment {

    private static final String TAG = EvalSkillsFragment.class.getSimpleName();

    private Toolbar toolbar;

    private RecyclerView skillPlayersRV, skillsRV;
    private List<Skills> list = new ArrayList<>();
    private List<Players> playersList = new ArrayList<>();
    private SkillsAdapter adapter;

    public EvalSkillsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eval_skills, container, false);
        initViews(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void initViews(View view) {
        toolbar = view.findViewById(R.id.toolbar);

        skillPlayersRV = view.findViewById(R.id.skillPlayersRV);
        skillsRV = view.findViewById(R.id.skillsRV);

        skillPlayersRV.setHasFixedSize(true);
        skillsRV.setHasFixedSize(true);

        LinearLayoutManager hlm = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        skillPlayersRV.setLayoutManager(hlm);

        skillsRV.setLayoutManager(new LinearLayoutManager(getActivity()));

//        getPlayers();
//        populatePlayers();
        new GetSkillsTask().execute();

        getPlayersAsync();
        populatePlayers();

    }

    private List<Players> getPlayersAsync() {
        SQLite.select()
                .from(Players.class)
                .async()
                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Players>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<Players> tResult) {
                        playersList = tResult;
                    }
                }).execute();
        return playersList;
    }

    private class GetSkillsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            getSkillsToEvaluate();
            return null;
        }
    }

    private void populatePlayers() {
        skillPlayersRV.setAdapter(new SkillsPlayersAdapter(getActivity(), getPlayersAsync()));
    }


    private void getSkillsToEvaluate() {
        AndroidNetworking.get(Constants.BASE_URL + "get_basketball_skills")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Skills Resp:\t" + response.toString());
                        try {
                            JSONObject object = new JSONObject(response.toString());
                            JSONArray jsonArray = object.getJSONArray("skills");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                Skills skills = new Skills();
                                skills.setName(jsonObject.getString("skill_name"));
                                skills.setSkillId(jsonObject.getString("skill_id"));
                                skills.setAcadId(jsonObject.getString("academy_id"));

                                list.add(skills);
                                adapter = new SkillsAdapter(getActivity(), list);
                                skillsRV.setAdapter(adapter);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

}
