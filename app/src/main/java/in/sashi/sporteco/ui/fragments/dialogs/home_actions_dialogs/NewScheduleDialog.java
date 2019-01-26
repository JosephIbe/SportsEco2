package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ProgramsAdapter;
import in.sashi.sporteco.adapters.ScheduleSessionsAdapter;
import in.sashi.sporteco.models.app.Programs;
import in.sashi.sporteco.models.sessions.Sessions;
import in.sashi.sporteco.ui.activities.ProgramsActivity;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;
import in.sashi.sporteco.utils.MultiLineRadioGroup;

public class NewScheduleDialog extends DialogFragment {

    private static final String TAG = NewScheduleDialog.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private Button schedDoneBtn;

    private RecyclerView scheduleSessionsRV;

    private RadioButton radioButton;
    private MultiLineRadioGroup programsGroup;

    private List<Sessions> list = new ArrayList<>();
    private List<Programs> programsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_schedule_dialog, container, false);
        init(view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        backIV = view.findViewById(R.id.backIV);
        programsGroup = view.findViewById(R.id.programsGroup);
        scheduleSessionsRV = view.findViewById(R.id.scheduleSessionsRV);
        schedDoneBtn = view.findViewById(R.id.schedDoneBtn);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setUpSessionsRV();

        schedDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "What Next?", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setUpSessionsRV() {
        scheduleSessionsRV.setHasFixedSize(true);
        scheduleSessionsRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        fetchPrograms();
        populate();

    }

    private void populate() {
        SQLite.select()
                .from(Sessions.class)
                .async()
                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Sessions>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<Sessions> tResult) {
                        list = tResult;
                        scheduleSessionsRV.setAdapter(new ScheduleSessionsAdapter(getActivity(), list));
                    }
                }).execute();
    }

    private void fetchPrograms() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", AppUtils.getCoachId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "coach_programs_screen")
                .setPriority(Priority.HIGH)
                .addJSONObjectBody(jsonObject)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Response:\t" + response.toString());
                        try {
                            JSONObject  object = new JSONObject(response.toString());
//                            JSONArray array = object.getJSONArray("programs");
                            JSONArray array = object.getJSONArray("program_details");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject obj = array.getJSONObject(i);

                                Programs programs = new Programs();
                                String name = obj.getString("prg_name");
                                programs.setProgramName(name);
                                programs.setProgId(obj.getString("prg_id"));
                                programs.setNumSessions(obj.getString("prg_no_session"));
                                programs.setStartDate(obj.getString("prg_start_date"));
                                programs.setProgImg(obj.getString("prg_image"));
                                programs.setPlaceName(null);
                                programs.setProgramDesc(null);
                                programs.setPlayer_count(obj.getString("player_count"));

                                programsList.add(programs);
//                                programs.save();

                                Log.d(TAG, "pn:\t" + name);
                                Log.d(TAG, "pid:\t" + programsList.get(i).progId);
                                Log.d(TAG, "pn:\t" + programs.getProgramName());
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
