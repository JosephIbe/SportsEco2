package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.DrillsAdapter;
import in.sashi.sporteco.models.drills.Drills;
import in.sashi.sporteco.utils.Constants;

public class StartSessionDialogFragment extends DialogFragment {

    private static final String TAG = StartSessionDialogFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private TextView nameSessStartTV;

    private String session_name, session_id;

    private RecyclerView startSessRV;
    private List<Drills> itemsList = new ArrayList<>();
    private DrillsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session_name = getArguments().getString(Constants.SESSION_NAME_KEY);
        session_id = getArguments().getString(Constants.SESSION_ID_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_session_dialog, container, false);

        init(view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        nameSessStartTV.setText(session_name);

        return view;

    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        backIV = view.findViewById(R.id.backIV);
        nameSessStartTV = view.findViewById(R.id.nameSessStartTV);
        startSessRV = view.findViewById(R.id.startSessRV);

        setUpRV();

    }

    private void setUpRV() {
        startSessRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        startSessRV.setLayoutManager(llm);
        startSessRV.addItemDecoration(new DividerItemDecoration(getActivity(), llm.getOrientation()));

        mockDrills();

        getSessionDrills();

    }

    private void getSessionDrills() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(Constants.SESSION_ID_KEY, session_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(Constants.BASE_URL + "session_drills_list")
                .addJSONObjectBody(jsonObject)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Sesh Drills Response:\t" + response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    private void mockDrills() {
        Drills one = new Drills();
        one.setPlaying(false);
        one.setFavorite(false);
        one.setTitle("Carolina Shooting1");
        one.setDuration("05:01");
        one.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(one);

        Drills two = new Drills();
        two.setPlaying(false);
        two.setFavorite(false);
        two.setTitle("Carolina Shooting2");
        two.setDuration("01:02");
        two.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(two);

        Drills three = new Drills();
        three.setPlaying(false);
        three.setFavorite(false);
        three.setTitle("Carolina Shooting3");
        three.setDuration("05:03");
        three.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(three);

        Drills four = new Drills();
        four.setPlaying(false);
        four.setFavorite(false);
        four.setTitle("Carolina Shooting4");
        four.setDuration("05:04");
        four.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(four);

        Drills five = new Drills();
        five.setPlaying(false);
        five.setFavorite(false);
        five.setTitle("Carolina Shooting5");
        five.setDuration("05:05");
        five.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(five);

        Drills six = new Drills();
        six.setPlaying(false);
        six.setFavorite(false);
        six.setTitle("Carolina Shooting6");
        six.setDuration("05:06");
        six.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(six);

        Drills seven = new Drills();
        seven.setPlaying(false);
        seven.setFavorite(false);
        seven.setTitle("Carolina Shooting7");
        seven.setDuration("05:07");
        seven.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(seven);

        Drills eight = new Drills();
        eight.setPlaying(false);
        eight.setFavorite(false);
        eight.setTitle("Carolina Shooting8");
        eight.setDuration("05:08");
        eight.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(eight);

        Drills nine = new Drills();
        nine.setPlaying(false);
        nine.setFavorite(false);
        nine.setTitle("Carolina Shooting9");
        nine.setDuration("05:09");
        nine.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(nine);

        adapter = new DrillsAdapter(getActivity(), itemsList);
        startSessRV.setAdapter(adapter);

    }

}
