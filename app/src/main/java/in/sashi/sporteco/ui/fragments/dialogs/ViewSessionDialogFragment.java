package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.ProgramSessionDetails;
import in.sashi.sporteco.models.app.ProgramSessionDetails_Table;
import in.sashi.sporteco.utils.Constants;

public class ViewSessionDialogFragment extends DialogFragment implements View.OnClickListener {

    private static final String TAG = ViewSessionDialogFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private TextView nameSessTV, sessDescTV;
    private Button attendanceBtn, startBtn, addPlayerBtn;

    private RecyclerView prog_FocusRV, prog_EquipmentsRV;

    private String progSessionId, session_name;
    private ProgramSessionDetails details;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progSessionId = getArguments().getString(Constants.PROGRAM_SESSION_ID_KEY);
        Log.d(TAG, "ProgSessId:\t" + progSessionId);

        details = SQLite.select()
                .from(ProgramSessionDetails.class)
                .where(ProgramSessionDetails_Table.progSessionId.is(progSessionId))
                .querySingle();

        Log.d(TAG, "PSD NumDrills:\t" + details.getProgSessionNumDrills());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_session, container, false);

        init(view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

//        session_name = getIntent().getExtras().getString("session_name");
//        nameSessTV.setText(session_name);

        backIV.setOnClickListener(this);

        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        backIV = view.findViewById(R.id.backIV);
        nameSessTV = view.findViewById(R.id.progSessionNameTV);
        sessDescTV = view.findViewById(R.id.progSessionDescTV);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backIV:
                dismiss();
                break;
        }
    }
}
