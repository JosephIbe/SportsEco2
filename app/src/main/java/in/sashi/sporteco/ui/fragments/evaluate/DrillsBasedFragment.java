package in.sashi.sporteco.ui.fragments.evaluate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.EvalDrillsAdapter;
import in.sashi.sporteco.models.drills.EvalDrills;
import in.sashi.sporteco.utils.AppUtils;
import in.sashi.sporteco.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrillsBasedFragment extends Fragment {

    private static final String TAG = DrillsBasedFragment.class.getSimpleName();

    private RecyclerView evalDrillsRV;

    private List<EvalDrills> list = new ArrayList<>();
    private EvalDrillsAdapter adapter;

    public DrillsBasedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drills_based, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        evalDrillsRV = view.findViewById(R.id.evalDrillsRV);
        evalDrillsRV.setHasFixedSize(true);
        evalDrillsRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchDrills(AppUtils.getCoachId());

    }

    private void fetchDrills(String coachId) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("coach_id", coachId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "evaluate_screen")
                .addJSONObjectBody(jsonObject)
                .setTag("Get Sessions to Evaluate")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
//                            Log.d(TAG, "EvalSesh Resp:\t" + response.toString());
                            try {
                                JSONObject object = new JSONObject(response.toString());
                                JSONArray array = object.getJSONArray("session_details");
                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject details = array.getJSONObject(i);

                                    //drills
                                    JSONArray jsonArray = details.getJSONArray("drills");
                                    for (int m = 0; m < jsonArray.length(); m++) {
                                        JSONObject obj = jsonArray.getJSONObject(m);

                                        EvalDrills drills = new EvalDrills();
                                        drills.isExpanded = false;
                                        drills.progSessId = obj.getString("prg_session_id");
                                        drills.progSessStepsId = obj.getString("prg_session_steps_id");
                                        drills.progDrillSessionMapping = obj.getString("spt_drill_session_mapping");
                                        drills.progDrillName = obj.getString("prg_drill_name");
                                        drills.progDrillImg = obj.getString("prg_session_drill_image");
                                        drills.progDrillDurn = obj.getString("prg_session_drill_duration");
                                        drills.progDrillDesc = obj.getString("prg_session_drill_description");
                                        drills.progDrillFocusPts = obj.getString("prg_session_drill_focusPoint");
                                        drills.progDrillVideoURL = obj.getString("prg_session_drill_video");

                                        list.add(drills);
                                        drills.save();

                                        adapter = new EvalDrillsAdapter(getActivity(), list);
                                        evalDrillsRV.setAdapter(adapter);
                                    }

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

}
