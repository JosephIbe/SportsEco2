package in.sashi.sporteco.ui.fragments.evaluate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
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
import in.sashi.sporteco.adapters.EvalSessionsAdapter;
import in.sashi.sporteco.models.players.EvalSessionPlayers;
import in.sashi.sporteco.models.sessions.EvalSessions;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvalSessionsFragment extends Fragment {

    private static final String TAG = EvalSessionsFragment.class.getSimpleName();

    private RecyclerView sessionsEvalRV;
    private List<EvalSessions> list = new ArrayList<>();
    private EvalSessionsAdapter adapter;

    public EvalSessionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eval_sessions, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        sessionsEvalRV = view.findViewById(R.id.sessionsEvalRV);

        sessionsEvalRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        sessionsEvalRV.setLayoutManager(llm);
        sessionsEvalRV.addItemDecoration(new DividerItemDecoration(getActivity(), llm.getOrientation()));

        getSessions();

    }

    private void getSessions() {

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
//                            Log.d(TAG, "EvalSesh Resp:\t" + response.toString());
                            try {
                                JSONObject object = new JSONObject(response.toString());
                                JSONArray array = object.getJSONArray("session_details");
                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject details = array.getJSONObject(i);

                                    EvalSessions sessions = new EvalSessions();
                                    sessions.sessionId = details.getString("prg_session_id");
                                    sessions.sessionName = details.getString("prg_session_name");
                                    sessions.program_name = details.getString("prg_name");
                                    sessions.batch_name = details.getString("batch_name");
                                    sessions.sessionIcon = details.getString("prg_session_image");
                                    sessions.sessionTime = details.getString("session_start_time");
                                    sessions.date_start = details.getString("prg_session_start_datetime");
                                    sessions.date_end = details.getString("prg_session_end_datetime");
                                    sessions.date = details.getString("session_start_date");
                                    sessions.presentCount = details.getString("present_count");
                                    sessions.totalCount = details.getString("player_count");

                                    //players
                                    JSONArray jsonArray = details.getJSONArray("players");
                                    for (int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject obj = jsonArray.getJSONObject(j);

                                        EvalSessionPlayers players = new EvalSessionPlayers();
                                        players.firstName = obj.getString("first_name");
                                        players.lastName = obj.getString("last_name");
                                        players.userId = obj.getString("player_id");
                                        players.username = obj.getString("username");
                                        players.address = obj.getString("address");
                                        players.imageURL = obj.getString("image");
                                        players.statePlayer = obj.getString("state");
                                        players.attendanceStatus = obj.getString("att_status");
                                        players.sessionId = details.getString("prg_session_id");
                                        sessions.sessionPlayers = players;

                                        players.save();

                                    }

                                    list.add(sessions);
                                    sessions.save();

                                    adapter = new EvalSessionsAdapter(getActivity(), list);
                                    sessionsEvalRV.setAdapter(adapter);
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
