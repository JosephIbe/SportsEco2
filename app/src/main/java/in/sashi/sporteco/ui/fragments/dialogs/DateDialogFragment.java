package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import in.sashi.sporteco.R;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;
import in.sashi.sporteco.utils.RoundedCornersSheet;

public class DateDialogFragment extends RoundedCornersSheet {

    private static final String TAG = DateDialogFragment.class.getSimpleName();

    private TextView dateText;
    private String dateSel, dateFormatted;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dateSel = getArguments().getString("date_sel");
        dateFormatted = getArguments().getString("date_formatted");
        if (dateSel != null && dateFormatted != null){
            Log.d(TAG, "Date passed:\t" + dateSel + "\t and formatted:\t" + dateFormatted);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.date_dialog_layout, container, false);

        dateText = v.findViewById(R.id.dateText);
        dateText.setText(dateFormatted);

        getDateSessions(dateSel);

        return v;
    }

    private void getDateSessions(String dateSel) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", AppUtils.getCoachId());
//            jsonObject.put("calendar_date", );
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
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

}
