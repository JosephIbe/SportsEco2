package in.sashi.sporteco.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.HistoryAdapter;
import in.sashi.sporteco.models.sessions.HistorySessions;
import in.sashi.sporteco.models.sessions.PlayerSession;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceHistoryFragment extends Fragment {

    private static final String TAG = AttendanceHistoryFragment.class.getSimpleName();

    private RecyclerView historyRV;
    private ProgressBar progress;

    private List<HistorySessions> sessionsList = new ArrayList<>();
    private HistoryAdapter adapter;

    public AttendanceHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance_history, container, false);

        initViews(view);

        getPastSessions();
//        mockSessions();

        return view;
    }

    private void getPastSessions() {

        String coachId = AppUtils.getCoachId();
        Log.d(TAG, "Coach id in upcoming:\t" + coachId);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", coachId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "session_attendance_list")
                .setPriority(Priority.HIGH)
                .addJSONObjectBody(jsonObject)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Response:\t" + response.toString());
                        try {
                            JSONObject object = new JSONObject(response.toString());
                            JSONArray upcoming = object.getJSONArray("history_sessions");
                            for (int m = 0; m < upcoming.length(); m++) {
                                JSONObject details = upcoming.getJSONObject(m);

                                HistorySessions sessions = new HistorySessions();
                                sessions.setSession_name(details.getString("prg_session_name"));
                                sessions.setSession_id(details.getString("prg_session_id"));
                                sessions.setBatch_name(details.getString("batch_name"));
                                sessions.setProgram_name(details.getString("prg_name"));
                                sessions.setEquipments_reqd(details.getString("prg_session_equipment"));
//                                sessions.setSess_duration(details.getString("prg_session_duration"));
//                                sessions.setDateTime(details.getString("session_time"));
                                sessions.setDate_start(details.getString("prg_session_start_datetime"));
                                sessions.setDate_end(details.getString("prg_session_end_datetime"));
                                sessions.setPresent_count(details.getString("present_count"));
                                sessions.setParticipants_count(details.getString("player_count"));
                                sessions.setIsComplete(details.getString("session_complete"));

                                JSONArray ps = details.getJSONArray("players");
                                PlayerSession playerSession = new PlayerSession();
                                for (int i = 0; i < ps.length(); i++){
                                    JSONObject obj = ps.getJSONObject(i);

                                    playerSession.setUserId(obj.getString("player_id"));
                                    playerSession.setFirstName(obj.getString("first_name"));
                                    playerSession.setLastName(obj.getString("last_name"));
                                    playerSession.setUsername(obj.getString("username"));
                                    playerSession.setImageURL(obj.getString("image"));
                                    playerSession.setAddress(obj.getString("address"));
                                    playerSession.setStatePlayer(obj.getString("state"));

                                    playerSession.save();

                                }

                                sessionsList.add(sessions);
                                Log.d(TAG, "Upcoming size:\t" + sessionsList.size());
                                sessions.save();

                                adapter = new HistoryAdapter(getActivity(), sessionsList);
                                historyRV.setAdapter(adapter);

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

    private void initViews(View view) {
        historyRV = view.findViewById(R.id.historyRV);

        historyRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        historyRV.setLayoutManager(llm);
        historyRV.addItemDecoration(new DividerItemDecoration(getActivity(), llm.getOrientation()));

    }

}
