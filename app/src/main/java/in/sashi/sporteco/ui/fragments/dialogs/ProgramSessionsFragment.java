package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ProgramsSessionsAdapter;
import in.sashi.sporteco.models.app.ProgramSessionDetails;
import in.sashi.sporteco.models.app.Programs;
import in.sashi.sporteco.models.app.Programs_Table;
import in.sashi.sporteco.models.app.Sessions;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;

public class ProgramSessionsFragment extends DialogFragment {

    private static final String TAG = ProgramSessionsFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;

    private TextView name_programTV, placeNameTV, desc_programTV;
    private RecyclerView programsSessionsRV;

    private List<ProgramSessionDetails> list = new ArrayList<>();
    private ProgramsSessionsAdapter adapter;

    private String programId;
    private Programs programs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        programId = getArguments().getString(Constants.PROGRAM_ID_KEY);

        programs = SQLite.select()
                .from(Programs.class)
                .where(Programs_Table.progId.is(programId))
                .querySingle();
        Log.d(TAG, "Query PName:\t" + programs.getProgramName());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_programs_sessions, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        name_programTV = view.findViewById(R.id.name_programTV);
        placeNameTV = view.findViewById(R.id.placeNameTV);
        desc_programTV = view.findViewById(R.id.desc_programTV);
        programsSessionsRV = view.findViewById(R.id.programsSessionsRV);

        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        set();

        setUpRV();

    }

    private void set() {
//        name_programTV.setText(getArguments().getString(PROGRAM_NAME_KEY));
//        desc_programTV.setText(getArguments().getString(PROGRAM_DESC_KEY));
//        placeNameTV.setText(getArguments().getString(PROGRAM_PLACE_NAME_KEY));

        name_programTV.setText(programs.getProgramName());
        desc_programTV.setText(programs.getProgramDesc());
        placeNameTV.setText(programs.getPlaceName());

    }

    private void setUpRV() {

        programsSessionsRV.setHasFixedSize(true);
        programsSessionsRV.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        getProgramDetails(AppUtils.getCoachId(), programId);

        List<ProgramSessionDetails> sessionDetailsList = SQLite.select()
                .from(ProgramSessionDetails.class)
                .queryList();

        adapter = new ProgramsSessionsAdapter(getActivity(), sessionDetailsList);
        programsSessionsRV.setAdapter(adapter);
    }

    private void getProgramDetails(String coachId, String pid) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", coachId);
            jsonObject.put("prg_id", pid);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "program_details_screen")
                .addJSONObjectBody(jsonObject)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "PDetails Response:\t" + response.toString());
                        try {
                            JSONObject object = new JSONObject(response.toString());
                            JSONArray array = object.getJSONArray("program_details");
                            for (int i = 0; i < array.length(); i++){
                                JSONObject obj = array.getJSONObject(i);
                                programs.setProgramDesc(obj.getString("prg_description"));
                                programs.setPlaceName(obj.getString("prg_place_name"));
                                programs.update();

                                JSONArray jsonArray = obj.getJSONArray("session_details");
                                for (int j = 0; j < jsonArray.length(); j++){
                                    JSONObject detailsObj = jsonArray.getJSONObject(j);

                                    ProgramSessionDetails sessionDetails = new ProgramSessionDetails();

                                    sessionDetails.setProgSessionId(detailsObj.getString("prg_session_id"));
                                    sessionDetails.setProgImage(detailsObj.getString("prg_image"));
                                    sessionDetails.setProgSessionName(detailsObj.getString("prg_session_name"));
                                    sessionDetails.setProgSessionNumDrills(detailsObj.getString("prg_session_no_drills"));
                                    sessionDetails.setProgId(detailsObj.getString("prg_id"));

                                    sessionDetails.save();

                                }

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

//    private void populate() {
//        Sessions one = new Sessions();
//        one.setSessionName("Session 1");
//        one.setNumSessions_Drills("21");
//        list.add(one);
//
//        Sessions two = new Sessions();
//        two.setSessionName("Session 2");
//        two.setNumSessions_Drills("21");
//        list.add(two);
//
//        Sessions three = new Sessions();
//        three.setSessionName("Session 3");
//        three.setNumSessions_Drills("21");
//        list.add(three);
//
//        Sessions four = new Sessions();
//        four.setSessionName("Session 4");
//        four.setNumSessions_Drills("21");
//        list.add(four);
//
//        Sessions five = new Sessions();
//        five.setSessionName("Session 5");
//        five.setNumSessions_Drills("21");
//        list.add(five);
//
//        Sessions six = new Sessions();
//        six.setSessionName("Session 6");
//        six.setNumSessions_Drills("21");
//        list.add(six);
//    }

}
