package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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
import in.sashi.sporteco.adapters.ProgramsAdapter;
import in.sashi.sporteco.models.app.Programs;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;

public class ProgramsActivity extends AppCompatActivity {

    private static final String TAG = ProgramsActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private RecyclerView programsRV;

    private FloatingActionButton addProgramFAB;

    private List<Programs> list = new ArrayList<>();
    private ProgramsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        init();
        setSupportActionBar(toolbar);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        backIV = findViewById(R.id.backIV);
        programsRV = findViewById(R.id.programsRV);
        addProgramFAB = findViewById(R.id.addProgramFAB);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProgramsActivity.this, MainActivity.class));
                finish();
            }
        });

        addProgramFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content), "Wll Add Programs Soon..Tune Later", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        setUpRV();

    }

    private void setUpRV() {
        programsRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        programsRV.setLayoutManager(llm);
        programsRV.addItemDecoration(new DividerItemDecoration(this, llm.getOrientation()));

        fetchPrograms();

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

                                list.add(programs);
                                adapter = new ProgramsAdapter(ProgramsActivity.this, list);
                                programsRV.setAdapter(adapter);
                                programs.save();

                                Log.d(TAG, "pn:\t" + name);
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

    private void populate() {
        Programs program1 = new Programs();
        program1.setNumSessions("4");
        program1.setProgramName("Program 1");
        program1.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program1.setPlaceName("Bangalore");
        program1.setStartDate("18/Dec/2018");
        list.add(program1);

        Programs program2 = new Programs();
        program2.setNumSessions("4");
        program2.setProgramName("Program 2");
        program2.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program2.setPlaceName("Bangalore");
        program2.setStartDate("18/Dec/2018");
        list.add(program2);

        Programs program3 = new Programs();
        program3.setNumSessions("4");
        program3.setProgramName("Program 3");
        program3.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program3.setPlaceName("Bangalore");
        program3.setStartDate("18/Dec/2018");
        list.add(program3);

        Programs program4 = new Programs();
        program4.setNumSessions("4");
        program4.setProgramName("Program 4");
        program4.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program4.setPlaceName("Bangalore");
        program4.setStartDate("18/Dec/2018");
        list.add(program4);

        Programs program5 = new Programs();
        program5.setNumSessions("4");
        program5.setProgramName("Program 5");
        program5.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program5.setPlaceName("Bangalore");
        program5.setStartDate("18/Dec/2018");
        list.add(program5);

        Programs program6 = new Programs();
        program6.setNumSessions("4");
        program6.setProgramName("Program 6");
        program6.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program6.setPlaceName("Bangalore");
        program6.setStartDate("18/Dec/2018");
        list.add(program6);

        Programs program7 = new Programs();
        program7.setNumSessions("4");
        program7.setProgramName("Program 7");
        program7.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program7.setPlaceName("Bangalore");
        program7.setStartDate("18/Dec/2018");
        list.add(program7);

        Programs program8 = new Programs();
        program8.setNumSessions("4");
        program8.setProgramName("Program 8");
        program8.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program8.setPlaceName("Bangalore");
        program8.setStartDate("18/Dec/2018");
        list.add(program8);

        Programs program9 = new Programs();
        program9.setNumSessions("4");
        program9.setProgramName("Program 9");
        program9.setProgramDesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        program9.setPlaceName("Bangalore");
        program9.setStartDate("18/Dec/2018");
        list.add(program9);

    }

}
