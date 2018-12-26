package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ProgramsSessionsAdapter;
import in.sashi.sporteco.models.app.Programs;
import in.sashi.sporteco.models.app.Sessions;

import static in.sashi.sporteco.utils.Constants.PROGRAM_DESC_KEY;
import static in.sashi.sporteco.utils.Constants.PROGRAM_NAME_KEY;
import static in.sashi.sporteco.utils.Constants.PROGRAM_PLACE_NAME_KEY;

public class ProgramSessionsFragment extends DialogFragment {

    private static final String TAG = ProgramSessionsFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;

    private TextView name_programTV, placeNameTV, desc_programTV;
    private RecyclerView programsSessionsRV;

    private List<Sessions> list = new ArrayList<>();
    private ProgramsSessionsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_programs_sessions, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        name_programTV = view.findViewById(R.id.name_programTV);
        placeNameTV = view.findViewById(R.id.placeNameTV);
        desc_programTV = view.findViewById(R.id.desc_programTV);
        programsSessionsRV = view.findViewById(R.id.programsSessionsRV);

        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        set();

        setUpRV();

    }

    private void set() {
        name_programTV.setText(getArguments().getString(PROGRAM_NAME_KEY));
        desc_programTV.setText(getArguments().getString(PROGRAM_DESC_KEY));
        placeNameTV.setText(getArguments().getString(PROGRAM_PLACE_NAME_KEY));
    }

    private void setUpRV() {

        programsSessionsRV.setHasFixedSize(true);
        programsSessionsRV.setLayoutManager(new GridLayoutManager(getActivity(), 3));

//        populate();

        adapter = new ProgramsSessionsAdapter(getActivity(), list);
        programsSessionsRV.setAdapter(adapter);
    }

//    private void populate() {
//        Sessions one = new Sessions();
//        one.setSessionName("Session 1");
//        one.setNumSessions_Drills("21");
//        list.add(one);
//
//        Sessions two = new Sessions();
//        two.setSessionName("Session 2");
//        two.setNumSessions_Drills("21");
//        list.add(two);
//
//        Sessions three = new Sessions();
//        three.setSessionName("Session 3");
//        three.setNumSessions_Drills("21");
//        list.add(three);
//
//        Sessions four = new Sessions();
//        four.setSessionName("Session 4");
//        four.setNumSessions_Drills("21");
//        list.add(four);
//
//        Sessions five = new Sessions();
//        five.setSessionName("Session 5");
//        five.setNumSessions_Drills("21");
//        list.add(five);
//
//        Sessions six = new Sessions();
//        six.setSessionName("Session 6");
//        six.setNumSessions_Drills("21");
//        list.add(six);
//    }

}
