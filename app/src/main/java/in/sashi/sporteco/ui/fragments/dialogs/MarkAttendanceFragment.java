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
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.MarkAttendanceAdapter;
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
    private List<PlayerSession> playersQueryList = new ArrayList<>();
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

//        sumPlayers = adapter.getItemCount();
//        Log.d(TAG, "Sum Players:\t" + sumPlayers);
//        totalTV.setText(sumPlayers + "");

//        numAbsent = sumPlayers - numPresent;
//        Log.d(TAG, "Num Absent:\t" + numAbsent);
//        absentTV.setText(numAbsent + "");

    }

    private void setUpView() {
        attRV.setHasFixedSize(true);
        attRV.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        // TODO: 1/5/2019 Get Players in session from session id
        getPlayersInSession(new Select().from(Sessions.class).querySingle().prog_sessionId);

//        populate(false);
        playersList = populate(false);
        adapter = new MarkAttendanceAdapter(getActivity(), playersList);
        attRV.setAdapter(adapter);

    }

    private List<PlayerSession> populate(final boolean select) {
        // TODO: 1/12/2019 Query with session & progSession id
        SQLite.select()
                .from(PlayerSession.class)
                .async()
                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<PlayerSession>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<PlayerSession> tResult) {
                        playersQueryList = tResult;
                        for (int i = 0; i < playersQueryList.size(); i++){
                            playersQueryList.get(i).setSelected(select);
                        }
                    }
                }).execute();
        return playersQueryList;
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
                                session.setSelected(false);

                                session.save();

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
            List<PlayerSession> selectAll = populate(true);
            adapter = new MarkAttendanceAdapter(getActivity(), selectAll);
            attRV.setAdapter(adapter);

            Log.d(TAG, "Select All Size:\t" + selectAll.size());
            presentTV.setText("" + selectAll.size());
            totalTV.setText("" + selectAll.size());
            absentTV.setText("0");

//            adapter.checkAll(isChecked);
        } else {
            List<PlayerSession> deSelectAll = populate(false);
            adapter = new MarkAttendanceAdapter(getActivity(), deSelectAll);
            attRV.setAdapter(adapter);

            Log.d(TAG, "Select All Size:\t" + deSelectAll.size());
            presentTV.setText("0");
            totalTV.setText("" + playersQueryList.size());
            absentTV.setText(deSelectAll.size() + "");

//            adapter.unCheckAll(isChecked);
        }
    }

}
