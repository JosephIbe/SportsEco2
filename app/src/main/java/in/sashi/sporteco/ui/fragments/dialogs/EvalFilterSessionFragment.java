package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import in.sashi.sporteco.R;

public class EvalFilterSessionFragment extends DialogFragment implements View.OnClickListener {

    private static final String TAG = EvalFilterSessionFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;

    private RadioButton todayBtn, yesterdayBtn, weekBtn;                                        //firstRow
    private RadioButton firstBtn, secondBtn;                                                  // yearRow
    private RadioButton janBtn, febBtn, marchBtn, aprilBtn, mayBtn, juneBtn, julyBtn,
            augustBtn, septBtn, octBtn, novBtn, decBtn;                                     // monthRow
    private RadioButton program1Btn, program2Btn, program3Btn;                             // programRow
    private RadioButton session1Btn, session2Btn;                                         // sessionRow

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eval_filter_sessions, container, false);

        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        todayBtn = view.findViewById(R.id.todayBtn);
        yesterdayBtn = view.findViewById(R.id.yesterdayBtn);
        weekBtn = view.findViewById(R.id.weekBtn);
        firstBtn = view.findViewById(R.id.firstBtn);
        secondBtn = view.findViewById(R.id.secondBtn);
        janBtn = view.findViewById(R.id.janBtn);
        febBtn = view.findViewById(R.id.febBtn);
        marchBtn = view.findViewById(R.id.marchBtn);
        aprilBtn = view.findViewById(R.id.aprilBtn);
        mayBtn = view.findViewById(R.id.mayBtn);
        juneBtn = view.findViewById(R.id.juneBtn);
        julyBtn = view.findViewById(R.id.julyBtn);
        augustBtn = view.findViewById(R.id.augustBtn);
        septBtn = view.findViewById(R.id.septBtn);
        octBtn = view.findViewById(R.id.octBtn);
        novBtn = view.findViewById(R.id.novBtn);
        decBtn = view.findViewById(R.id.decBtn);
        program1Btn = view.findViewById(R.id.program1Btn);
        program2Btn = view.findViewById(R.id.program2Btn);
        program3Btn = view.findViewById(R.id.program3Btn);
        session1Btn = view.findViewById(R.id.session1Btn);
        session2Btn = view.findViewById(R.id.session2Btn);

        closeIV.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.closeIV:
                dismiss();
                break;
        }
    }
}
