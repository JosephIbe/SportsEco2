package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class DrillsDetailsFragment extends DialogFragment implements View.OnClickListener {

    private static final String TAG = DrillsDetailsFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private TextView nameDrillTV, drillDescTV;
    private RecyclerView drillFocusRV, drillEquipmentsRV;
    private RelativeLayout startDrillBtn, evaluateDrillBtn;
    private LinearLayout drillActionsLayout;

    private String drill_name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        drill_name = getArguments().getString("drill_name");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_drills_details, container, false);

        init(v);

        backIV.setOnClickListener(this);
        evaluateDrillBtn.setOnClickListener(this);
        startDrillBtn.setOnClickListener(this);

        return v;
    }

    private void init(View v) {
        toolbar = v.findViewById(R.id.toolbar);
        backIV = v.findViewById(R.id.backIV);
        nameDrillTV = v.findViewById(R.id.nameDrillTV);
        drillDescTV = v.findViewById(R.id.drillDescTV);
        drillFocusRV = v.findViewById(R.id.drillFocusRV);
        drillEquipmentsRV = v.findViewById(R.id.drillEquipmentsRV);
        startDrillBtn = v.findViewById(R.id.startDrillBtn);
        evaluateDrillBtn = v.findViewById(R.id.evaluateDrillBtn);
        drillActionsLayout = v.findViewById(R.id.drillActionsLayout);

        nameDrillTV.setText(drill_name);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                dismiss();
                break;
            case R.id.evaluateDrillBtn:
                Snackbar.make(drillActionsLayout, "No UI Provided", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.startDrillBtn:
                Snackbar.make(drillActionsLayout, "No UI Provided", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

}
