package in.sashi.sporteco.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ActionsAdapter;
import in.sashi.sporteco.adapters.SessionsAdapter;
import in.sashi.sporteco.adapters.TodoAdapter;
import in.sashi.sporteco.interfaces.RecyclerClickListener;
import in.sashi.sporteco.models.app.HomeActions;
import in.sashi.sporteco.models.app.Sessions;
import in.sashi.sporteco.models.app.ToDo;
import in.sashi.sporteco.ui.activities.AttendanceMainActivity;
import in.sashi.sporteco.ui.activities.CalendarViewActivity;
import in.sashi.sporteco.ui.activities.EvaluateActivity;
import in.sashi.sporteco.ui.activities.PlayersActivity;
import in.sashi.sporteco.ui.activities.ProgramsActivity;
import in.sashi.sporteco.ui.fragments.dialogs.DateDialogFragment;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;
import in.sashi.sporteco.utils.RecyclerItemTouchListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements DatePickerListener {

    private static final String TAG = HomeFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView burgerIconIV, logoIV, notifsIV;
    private RecyclerView actionsRV, sessionsRV, todosRV;
    private TextView viewAllSchedulesTV;
    private HorizontalPicker picker;

    private List<HomeActions> actionsList = new ArrayList<>();
    private ActionsAdapter adapter;

    private List<Sessions> sessionsList = new ArrayList<>();
    private SessionsAdapter sessionsAdapter;

    private List<ToDo> toDoList = new ArrayList<>();
    private TodoAdapter todoAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        burgerIconIV = view.findViewById(R.id.burgerIconIV);
        logoIV = view.findViewById(R.id.logoIV);
        notifsIV = view.findViewById(R.id.notifsIV);
        actionsRV = view.findViewById(R.id.actionsRV);
        sessionsRV = view.findViewById(R.id.sessionsRV);
        todosRV = view.findViewById(R.id.todosRV);
        picker = view.findViewById(R.id.datePicker);
        viewAllSchedulesTV = view.findViewById(R.id.viewAllSchedulesTV);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        initPicker();

        setUpSessions();
        sessionsAdapter = new SessionsAdapter(getActivity(), sessionsList);
        sessionsRV.setAdapter(sessionsAdapter);

        setUpActions();

        setUpTodos();

        viewAllSchedulesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), CalendarViewActivity.class));
            }
        });

        return view;
    }

    private void setUpTodos() {
        todosRV.setHasFixedSize(true);
        todosRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        ToDo item1 = new ToDo();
        item1.setComplete(false);
        item1.setItemTitle("Complete September");
        toDoList.add(item1);

        ToDo item2 = new ToDo();
        item2.setComplete(false);
        item2.setItemTitle("Review October");
        toDoList.add(item2);

        ToDo item3 = new ToDo();
        item3.setComplete(false);
        item3.setItemTitle("Plan for November and so on...");
        toDoList.add(item3);

        todoAdapter = new TodoAdapter(getActivity(), toDoList);
        todosRV.setAdapter(todoAdapter);

    }

    private void setUpSessions() {
        sessionsRV.setHasFixedSize(true);
        LinearLayoutManager hlm = new LinearLayoutManager(getActivity());
        hlm.setOrientation(LinearLayoutManager.HORIZONTAL);
        sessionsRV.setLayoutManager(hlm);

        String coachId = AppUtils.getCoachId();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", coachId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "session_list")
                .setPriority(Priority.HIGH)
                .addJSONObjectBody(jsonObject)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "SeshResp:\t" + response.toString());
                        try {
                            JSONObject object = new JSONObject(response.toString());
                            JSONArray arr = object.getJSONArray("session_details");
                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject details = arr.getJSONObject(i);
                                Sessions sessions = new Sessions();
                                sessions.setSession_name(details.getString("prg_session_name"));
                                sessions.setBatch_name(details.getString("batch_name"));
                                sessions.setProgram_name(details.getString("prg_name"));
                                sessions.setSession_id(details.getString("prg_session_id"));
                                sessions.setIs_complete(details.getString("session_complete"));
                                sessions.setEquipments_reqd(details.getString("prg_session_equipment"));
                                sessions.setSession_desc(details.getString("prg_session_description"));
                                sessions.setSession_focus_points(details.getString("prg_session_focus_points"));
                                sessions.setParticipants_count(details.getString("player_count"));
                                sessions.setSessionIcon(details.getString("prg_session_image"));

                                sessionsList.add(sessions);
                                sessions.save();

                                sessionsAdapter = new SessionsAdapter(getActivity(), sessionsList);
                                sessionsRV.setAdapter(sessionsAdapter);

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

    private void initPicker() {
        picker.setListener(this)
                .setMonthAndYearTextColor(getActivity().getResources().getColor(R.color.white))
                .setDateSelectedColor(getActivity().getResources().getColor(R.color.white))
                .setDateSelectedTextColor(getActivity().getResources().getColor(R.color.event_color_03))
                .setTodayButtonTextColor(getActivity().getResources().getColor(R.color.white))
                .setTodayDateTextColor(getActivity().getResources().getColor(R.color.accent))
                .setUnselectedDayTextColor(getActivity().getResources().getColor(R.color.white))
                .init();
    }

    private void setUpActions() {
        actionsRV.setHasFixedSize(true);
        LinearLayoutManager hlm = new LinearLayoutManager(getActivity());
        hlm.setOrientation(LinearLayoutManager.HORIZONTAL);
        actionsRV.setLayoutManager(hlm);

        HomeActions actions = new HomeActions();
        actions.setActionName("Attendance");
        actions.setImg(R.drawable.ic_attendance);
        actionsList.add(actions);

        HomeActions actions1 = new HomeActions();
        actions1.setActionName("Evaluate");
        actions1.setImg(R.drawable.ic_evaluate);
        actionsList.add(actions1);

        HomeActions actions2 = new HomeActions();
        actions2.setActionName("Players");
        actions2.setImg(R.drawable.ic_players);
        actionsList.add(actions2);

        HomeActions actions3 = new HomeActions();
        actions3.setActionName("Programs");
        actions3.setImg(R.drawable.ic_programs);
        actionsList.add(actions3);

        HomeActions actions4 = new HomeActions();
        actions4.setActionName("Tips/VOD");
        actions4.setImg(R.drawable.ic_tips_vod);
        actionsList.add(actions4);

        adapter = new ActionsAdapter(getActivity(), actionsList);
        actionsRV.setAdapter(adapter);

        setActionsListener();

    }

    private void setActionsListener() {
        actionsRV.addOnItemTouchListener(new RecyclerItemTouchListener(getActivity(), actionsRV, new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(getActivity(), AttendanceMainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), EvaluateActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), PlayersActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), ProgramsActivity.class));
                        break;
                    case 4:
                        Toast.makeText(getActivity(), "VOD Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }));
    }

    @Override
    public void onDateSelected(DateTime dateSelected) {
        String splicedDate = dateSelected.toString().substring(0, 10);
        Log.d(TAG, "Selected date is " + splicedDate);
        Toast.makeText(getActivity(), "Selected date is " + splicedDate, Toast.LENGTH_SHORT).show();

        String fd = null;
        Bundle bundle = new Bundle();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("EEE, dd MMM yyyy");

        try {
            Date date = sdf.parse(splicedDate);
            fd = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        bundle.putString("date_sel", splicedDate);
        bundle.putString("date_formatted", fd);

        DateDialogFragment dateDialogFragment = new DateDialogFragment();
        dateDialogFragment.setArguments(bundle);
        dateDialogFragment.show(getActivity().getSupportFragmentManager(), "DateDialogFragment");

    }

}
