package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.raizlabs.android.dbflow.sql.language.Select;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.MarkAttendanceAdapter;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.models.sessions.PlayerSession;
import in.sashi.sporteco.models.sessions.Sessions;
import in.sashi.sporteco.utils.Constants;

public class MarkAttendanceFragment extends DialogFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = MarkAttendanceFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;
    private TextView sessionNameAttendanceTV, totalTV, presentTV, absentTV;
    private Button doneBtn;

    private CheckBox checkAll;

    private RecyclerView attRV;
    private MarkAttendanceAdapter adapter;
    private List<PlayerSession> playersList = new ArrayList<>();

    private int numPresent = 0, numAbsent = 0, sumPlayers = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mark_attendance, container, false);

        init(view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        closeIV.setOnClickListener(this);
        checkAll.setOnCheckedChangeListener(this);
        doneBtn.setOnClickListener(this);

        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        sessionNameAttendanceTV = view.findViewById(R.id.sessionNameAttendanceTV);
        checkAll = view.findViewById(R.id.checkAll);
        attRV = view.findViewById(R.id.attRV);
        totalTV = view.findViewById(R.id.totalTV);
        presentTV = view.findViewById(R.id.presentTV);
        absentTV = view.findViewById(R.id.absentTV);
        doneBtn = view.findViewById(R.id.submitBtn);

        setUpView();

//        numPresent = adapter.sendNumChecked();
//        Log.d(TAG, "Num Checked:\t" + numPresent);
//        presentTV.setText(numPresent + "");
//
//        sumPlayers = adapter.getItemCount();
//        Log.d(TAG, "Sum Players:\t" + sumPlayers);
//        totalTV.setText(sumPlayers + "");
//
//        numAbsent = sumPlayers - numPresent;
//        Log.d(TAG, "Num Absent:\t" + numAbsent);
//        absentTV.setText(numAbsent + "");

    }

    private void setUpView() {
        attRV.setHasFixedSize(true);
        attRV.setLayoutManager(new GridLayoutManager(getActivity(), 3));

//        populate();
        // TODO: 1/5/2019 Get Players in session from session id
        getPlayersInSession(new Select().from(Sessions.class).querySingle().prog_sessionId);

    }

    private void getPlayersInSession(final String program_sessId) {
        Log.d(TAG, "Sessid in maf:\t" + program_sessId);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("prg_session_id", program_sessId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "session_player_list")
                .addJSONObjectBody(jsonObject)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Sesh Players Response:\t" + response.toString());
                        try {
                            JSONObject object = new JSONObject(response.toString());
                            JSONArray array = object.getJSONArray("players");

                            for (int i = 0; i < array.length(); i++){
                                JSONObject obj = array.getJSONObject(i);

                                PlayerSession session = new PlayerSession();
                                session.setUsername(obj.getString("username"));
                                session.setAddress(obj.getString("address"));
                                session.setAttendanceStatus("0");
                                session.setFirstName(obj.getString("first_name"));
                                session.setLastName(obj.getString("last_name"));
                                session.setImageURL(obj.getString("image"));
                                session.setStatePlayer(obj.getString("state"));
                                session.setUserId(obj.getString("player_id"));
                                session.setProgSessId(program_sessId);

                                session.save();
                                playersList.add(session);
                                adapter = new MarkAttendanceAdapter(getActivity(), playersList);
                                attRV.setAdapter(adapter);

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
//        Players one = new Players();
//        one.setFirstName("Joseph");
//        one.setLastName("Joey");
//        one.setImageURL("https://bit.ly/2QoW661");
//        one.setSelected(false);
//        playersList.add(one);
//
//        Players two = new Players();
//        two.setFirstName("Nikola");
//        two.setLastName("Jokic");
//        two.setImageURL("https://bit.ly/2DK1GJD");
//        two.setSelected(false);
//        playersList.add(two);
//
//        Players three = new Players();
//        three.setFirstName("Michael");
//        three.setLastName("Jordan");
//        three.setImageURL("https://bit.ly/2DK1GJD");
//        three.setSelected(false);
//        playersList.add(three);
//
//        Players four = new Players();
//        four.setFirstName("Cheryl");
//        one.setLastName("Miller");
//        four.setImageURL("https://bit.ly/2SaeAEs");
//        four.setSelected(true);
//        playersList.add(four);
//
//        Players five = new Players();
//        five.setFirstName("Dwayne");
//        five.setLastName("Wade");
//        five.setImageURL("https://bit.ly/2DK1GJD");
//        five.setSelected(true);
//        playersList.add(five);
//
//        Players six = new Players();
//        six.setFirstName("Maya");
//        six.setLastName("Moore");
//        six.setImageURL("https://bit.ly/2SaeAEs");
//        playersList.add(six);
//
//        Players seven = new Players();
//        seven.setFirstName("Steph");
//        seven.setLastName("Curry");
//        seven.setImageURL("https://bit.ly/2DK1GJD");
//        playersList.add(seven);
//
//        Players eight = new Players();
//        eight.setFirstName("Lisa");
//        eight.setLastName("Leslie");
//        eight.setImageURL("https://bit.ly/2SaeAEs");
//        playersList.add(eight);
//
//        Players nine = new Players();
//        nine.setFirstName("Lebron");
//        nine.setLastName("Blabla");
//        nine.setImageURL("https://bit.ly/2DK1GJD");
//        playersList.add(nine);
//
//        Players ten = new Players();
//        ten.setFirstName("Diana");
//        ten.setLastName("Taurasi");
//        ten.setImageURL("https://bit.ly/2SaeAEs");
//        playersList.add(ten);
//
//        adapter = new MarkAttendanceAdapter(getActivity(), playersList);
//        attRV.setAdapter(adapter);
//
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.closeIV:
                dismiss();
                break;
            case R.id.submitBtn:
                Snackbar.make(getActivity().findViewById(android.R.id.content), "Please Mark Attendance", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            adapter.checkAll();
        } else {
            adapter.unCheckAll();
        }
    }

}
