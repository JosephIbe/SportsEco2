package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Programs;
import in.sashi.sporteco.models.sessions.Sessions;

public class EvalFilterSessionFragment extends DialogFragment implements View.OnClickListener {

    private static final String TAG = EvalFilterSessionFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;

    private RadioButton todayBtn, yesterdayBtn, weekBtn;
    private RadioButton firstBtn, secondBtn;
    private RadioButton janBtn, febBtn, marchBtn, aprilBtn, mayBtn, juneBtn, julyBtn,
            augustBtn, septBtn, octBtn, novBtn, decBtn;

    private RadioGroup programsGroup;
    private RadioGroup sessionsGroup;
    private RadioButton sessionButton, programsButton;

    private List<Programs> programs;
    private List<Sessions> sessions;

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
        programsGroup = view.findViewById(R.id.programsGroup);
        sessionsGroup = view.findViewById(R.id.sessionsGroup);

        closeIV.setOnClickListener(this);

        programs = SQLite.select()
                .from(Programs.class)
                .queryList();
        Log.d(TAG, "Programs Size:\t" + programs.size());

        sessions = SQLite.select()
                .from(Sessions.class)
                .queryList();
        Log.d(TAG, "Sessions Size:\t" + programs.size());

        for (int i = 0; i < programs.size() && i < sessions.size(); i++){
            Log.d(TAG, "PNames:\t" + programs.get(i).programName);
            Log.d(TAG, "SNames:\t" + sessions.get(i).session_name);

            // programs buttons
            programsButton = new RadioButton(getActivity());
            programsButton.setId(Integer.parseInt(programs.get(i).progId));
            programsButton.setBackground(getActivity().getResources().getDrawable(R.drawable.filter_btns_bkg));
            programsButton.setButtonDrawable(null);
            programsButton.setPadding(10, 8, 10, 8);
            programsButton.setText(programs.get(i).programName);
            programsButton.setMinimumWidth(80);
            programsButton.setTextColor(getResources().getColor(R.color.text_color));
            programsButton.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
            programsGroup.addView(programsButton);

            // sessions buttons
            sessionButton = new RadioButton(getActivity());
            sessionButton.setId(Integer.parseInt(programs.get(i).progId));
            sessionButton.setBackground(getActivity().getResources().getDrawable(R.drawable.filter_btns_bkg));
            sessionButton.setButtonDrawable(null);
            sessionButton.setPadding(20, 8, 20, 8);
            sessionButton.setText(sessions.get(i).session_name);
            sessionButton.setMinimumWidth(80);
            sessionButton.setTextColor(getResources().getColor(R.color.text_color));
            sessionButton.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
            sessionsGroup.addView(sessionButton);

        }

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
