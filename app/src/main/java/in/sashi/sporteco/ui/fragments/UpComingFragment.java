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
                                sessions.setDateTime(details.getString("session_time"));
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

//    private void mockSessions() {
//        Sessions item1 = new Sessions();
//        item1.setSessionName("Session 1");
//        item1.setNumSessions_Drills("No. Session : 8");
//        item1.setBatchName("Batch 1");
//        item1.setProgramName("Program 1");
//        item1.setParticipantsCount("30");
//        item1.setPresentCountPlayers("5");
//        item1.setHour_start("05:29");
//        item1.setDate_start("31-10-18");
//        sessionsList.add(item1);
//
//        Sessions item2 = new Sessions();
//        item2.setSessionName("Session 2");
//        item2.setNumSessions_Drills("No. Session : 8");
//        item2.setBatchName("Batch 1");
//        item2.setProgramName("Program 2");
//        item2.setParticipantsCount("30");
//        item2.setPresentCountPlayers("5");
//        item2.setHour_start("05:29");
//        item2.setDate_start("31-10-18");
//        sessionsList.add(item2);
//
//        Sessions item3 = new Sessions();
//        item3.setSessionName("Session 3");
//        item3.setNumSessions_Drills("No. Session : 8");
//        item3.setBatchName("Batch 2");
//        item3.setProgramName("Program 1");
//        item3.setParticipantsCount("30");
//        item3.setPresentCountPlayers("5");
//        item3.setHour_start("05:29");
//        item3.setDate_start("31-10-18");
//        sessionsList.add(item3);
//
//        Sessions item4 = new Sessions();
//        item4.setSessionName("Session 4");
//        item4.setNumSessions_Drills("No. Session : 8");
//        item4.setBatchName("Batch 4");
//        item4.setProgramName("Program 12");
//        item4.setParticipantsCount("30");
//        item4.setPresentCountPlayers("5");
//        item4.setHour_start("05:29");
//        item4.setDate_start("31-10-18");
//        sessionsList.add(item4);
//
//        Sessions item5 = new Sessions();
//        item5.setSessionName("Session 5");
//        item5.setNumSessions_Drills("No. Session : 8");
//        item5.setBatchName("Batch 2");
//        item5.setProgramName("Program 10");
//        item5.setParticipantsCount("30");
//        item5.setPresentCountPlayers("5");
//        item5.setHour_start("05:29");
//        item5.setDate_start("31-10-18");
//        sessionsList.add(item5);
//
//        Sessions item6 = new Sessions();
//        item6.setSessionName("Session 6");
//        item6.setNumSessions_Drills("No. Session : 8");
//        item6.setBatchName("Batch 4");
//        item6.setProgramName("Program 3");
//        item6.setParticipantsCount("30");
//        item6.setPresentCountPlayers("5");
//        item6.setHour_start("05:29");
//        item6.setDate_start("31-10-18");
//        sessionsList.add(item6);
//
//
//    }

}
