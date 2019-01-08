package in.sashi.sporteco.ui.fragments.evaluate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.EvalBatchAdapter;
import in.sashi.sporteco.models.batch.EvalBatch;
import in.sashi.sporteco.models.batch.EvalBatchPlayers;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvalBatchFragment extends Fragment {

    private static final String TAG = EvalBatchFragment.class.getSimpleName();

    private RecyclerView rv;
    private List<EvalBatch> list = new ArrayList<>();
    private EvalBatchAdapter adapter;

    public EvalBatchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eval_batch, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        rv = view.findViewById(R.id.batchListRV);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        getEvalBatches();


    }

    private void getEvalBatches() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", AppUtils.getCoachId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "evaluate_screen")
                .addJSONObjectBody(jsonObject)
                .setTag("Get Sessions to Evaluate")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            try {
                                JSONObject object = new JSONObject(response.toString());
                                JSONArray array = object.getJSONArray("batches");
                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject details = array.getJSONObject(i);

                                    EvalBatch batch = new EvalBatch();
                                    batch.batchId = details.getString("batch_id");
                                    batch.batchName = details.getString("batch_nmae");
                                    batch.programName = details.getString("prg_name");
                                    batch.playersCount = details.getString("player_count");

                                    EvalBatchPlayers players = new EvalBatchPlayers();
                                    JSONArray jsonArray = details.getJSONArray("players");
                                    for (int b = 0; b < jsonArray.length(); b++) {
                                        JSONObject obj = jsonArray.getJSONObject(b);

                                        players.userId = obj.getString("user_id");
                                        players.firstName = obj.getString("first_name");
                                        players.lastName = obj.getString("last_name");
                                        players.imageURL = obj.getString("image");
                                        players.address = obj.getString("address");
                                        players.statePlayer = obj.getString("state");
                                        players.username = obj.getString("username");

                                        players.save();

                                    }

                                    batch.batchPlayers = players;
                                    list.add(batch);
                                    batch.save();

                                    adapter = new EvalBatchAdapter(getActivity(), list);
                                    rv.setAdapter(adapter);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

}
