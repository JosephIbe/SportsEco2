package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.CalendarSessionsAdapter;
import in.sashi.sporteco.models.app.CalendarSessions;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;
import in.sashi.sporteco.utils.EmptyRecyclerView;
import in.sashi.sporteco.utils.RoundedCornersSheet;

public class DateDialogFragment extends RoundedCornersSheet {

    private static final String TAG = DateDialogFragment.class.getSimpleName();

    private TextView dateText;
    private String dateSel, dateFormatted;

    private EmptyRecyclerView calendarSessionRV;
    private LinearLayout emptyLayout;

    private List<CalendarSessions> list = new ArrayList<>();
    private CalendarSessionsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dateSel = getArguments().getString("date_sel");
        dateFormatted = getArguments().getString("date_formatted");
//        if (dateSel != null && dateFormatted != null){
//            Log.d(TAG, "Date passed:\t" + dateSel + "\t and formatted:\t" + dateFormatted);
//        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.date_dialog_layout, container, false);

        init(v);

        return v;
    }

    private void init(View v) {
        dateText = v.findViewById(R.id.dateText);
        calendarSessionRV = v.findViewById(R.id.calendarSessionRV);
        emptyLayout = v.findViewById(R.id.emptyLayout);

        dateText.setText(dateFormatted);

        getDateSessions(dateSel);
        setUpRV();

    }

    private void setUpRV() {
        calendarSessionRV.setHasFixedSize(true);
        calendarSessionRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        calendarSessionRV.setEmptyView(emptyLayout);
    }

    private void getDateSessions(String dateSel) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", AppUtils.getCoachId());
//            jsonObject.put("calendar_date", dateSel);
            jsonObject.put("calendar_date", "2018-12-09");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "calendar_session_list")
                .addJSONObjectBody(jsonObject)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Cal Sesh Resp:\t" + response.toString());
                        try {
                            JSONObject object = new JSONObject(response.toString());
                            JSONArray array = object.getJSONArray("calendar_session_details");
                            for (int i = 0; i < array.length(); i++){
                                JSONObject obj = array.getJSONObject(i);
                                CalendarSessions sessions = new CalendarSessions();
                                sessions.setSessionName(obj.getString("prg_session_name"));
                                sessions.setProgramName(obj.getString("prg_name"));
                                sessions.setBatchName(obj.getString("batch_name"));
                                sessions.setSessionTime(obj.getString("prg_session_time"));
//                                sessions.setSessionNumPlayers(obj.getString(""));

                                list.add(sessions);
                                adapter = new CalendarSessionsAdapter(getActivity(), list);
                                calendarSessionRV.setAdapter(adapter);

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
