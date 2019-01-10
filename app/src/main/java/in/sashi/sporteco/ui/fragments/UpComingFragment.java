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
import in.sashi.sporteco.adapters.UpComingAdapter;
import in.sashi.sporteco.models.sessions.UpComingSessions;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpComingFragment extends Fragment {

    private static final String TAG = UpComingFragment.class.getSimpleName();

    private RecyclerView upComingRV;
//    private ProgressBar progress;

    private UpComingAdapter adapter;
    private List<UpComingSessions> sessionsList = new ArrayList<>();

    public UpComingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_up_coming, container, false);

        initViews(view);

        return view;
    }

    private void initViews(View view) {
        upComingRV = view.findViewById(R.id.upComingRV);

        upComingRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        upComingRV.setLayoutManager(llm);
        upComingRV.addItemDecoration(new DividerItemDecoration(getActivity(), llm.getOrientation()));

//        mockSessions();
        getFutureSessions();

    }

    private void getFutureSessions() {

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
                            JSONArray upcoming = object.getJSONArray("upcoming_sessions");
                            for (int m = 0; m < upcoming.length(); m++) {
                                JSONObject details = upcoming.getJSONObject(m);

                                UpComingSessions sessions = new UpComingSessions();
                                sessions.setSessionName(details.getString("prg_session_name"));
                                sessions.setSession_id(details.getString("prg_session_id"));
                                sessions.setBatchName(details.getString("batch_name"));
                                sessions.setProgram_name(details.getString("prg_name"));
                                sessions.setEquipments_reqd(details.getString("prg_session_equipment"));
//                                sessions.setSessDuration(details.getString("prg_session_duration"));
//                                sessions.setDateTime(details.getString("session_time"));
                                sessions.setDate_start(details.getString("prg_session_start_datetime"));
                                sessions.setDate_end(details.getString("prg_session_end_datetime"));
                                sessions.setPresent_count(details.getString("present_count"));
                                sessions.setPlayers_count(details.getString("player_count"));
                                sessions.setIsComplete(details.getString("session_complete"));

                                sessionsList.add(sessions);
                                Log.d(TAG, "Upcoming size:\t" + sessionsList.size());
                                sessions.save();

                                adapter = new UpComingAdapter(getActivity(), sessionsList);
                                upComingRV.setAdapter(adapter);

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
