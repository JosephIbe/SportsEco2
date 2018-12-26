package in.sashi.sporteco.ui.fragments.evaluate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.EvalSessionsAdapter;
import in.sashi.sporteco.models.app.Sessions;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvalSessionsFragment extends Fragment {

    private static final String TAG = EvalSessionsFragment.class.getSimpleName();

    private RecyclerView sessionsEvalRV;
    private List<Sessions> list = new ArrayList<>();
    private EvalSessionsAdapter adapter;

    public EvalSessionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eval_sessions, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        sessionsEvalRV = view.findViewById(R.id.sessionsEvalRV);

        sessionsEvalRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        sessionsEvalRV.setLayoutManager(llm);
        sessionsEvalRV.addItemDecoration(new DividerItemDecoration(getActivity(), llm.getOrientation()));

//        populate();

    }

//    private void populate() {
//        Sessions sessions = new Sessions();
//        sessions.setSessionName("Session 1");
//        sessions.setProgramName("Program 1");
//        sessions.setParticipantsCount("40");
//        sessions.setPresentCountPlayers("8");
//        sessions.setBatchName("Batch 1");
//        sessions.setDateTime("12-Sep-18");
//        sessions.setHour_start("3:30pm");
//        list.add(sessions);
//
//        Sessions sessions2 = new Sessions();
//        sessions2.setSessionName("Session 2");
//        sessions2.setProgramName("Program 2");
//        sessions2.setParticipantsCount("40");
//        sessions2.setPresentCountPlayers("8");
//        sessions2.setBatchName("Batch 1");
//        sessions2.setDateTime("12-Sep-18");
//        sessions2.setHour_start("3:30pm");
//        list.add(sessions2);
//
//        Sessions sessions3 = new Sessions();
//        sessions3.setSessionName("Session 3");
//        sessions3.setProgramName("Program 3");
//        sessions3.setParticipantsCount("40");
//        sessions3.setPresentCountPlayers("8");
//        sessions3.setBatchName("Batch 1");
//        sessions3.setDateTime("12-Sep-18");
//        sessions3.setHour_start("3:30pm");
//        list.add(sessions3);
//
//        Sessions sessions4 = new Sessions();
//        sessions4.setSessionName("Session 4");
//        sessions4.setProgramName("Program 4");
//        sessions4.setParticipantsCount("40");
//        sessions4.setPresentCountPlayers("8");
//        sessions4.setBatchName("Batch 1");
//        sessions4.setDateTime("12-Sep-18");
//        sessions4.setHour_start("3:30pm");
//        list.add(sessions4);
//
//        Sessions sessions5 = new Sessions();
//        sessions5.setSessionName("Session 5");
//        sessions5.setProgramName("Program 5");
//        sessions5.setParticipantsCount("40");
//        sessions5.setPresentCountPlayers("8");
//        sessions5.setBatchName("Batch 1");
//        sessions5.setDateTime("12-Sep-18");
//        sessions5.setHour_start("3:30pm");
//        list.add(sessions5);
//
//        Sessions sessions6 = new Sessions();
//        sessions6.setSessionName("Session 6");
//        sessions6.setProgramName("Program 6");
//        sessions6.setParticipantsCount("40");
//        sessions6.setPresentCountPlayers("8");
//        sessions6.setBatchName("Batch 1");
//        sessions6.setDateTime("12-Sep-18");
//        sessions6.setHour_start("3:30pm");
//        list.add(sessions6);
//
//        Sessions sessions7 = new Sessions();
//        sessions7.setSessionName("Session 7");
//        sessions7.setProgramName("Program 7");
//        sessions7.setParticipantsCount("40");
//        sessions7.setPresentCountPlayers("8");
//        sessions7.setBatchName("Batch 1");
//        sessions7.setDateTime("12-Sep-18");
//        sessions7.setHour_start("3:30pm");
//        list.add(sessions7);
//
//        Sessions sessions8 = new Sessions();
//        sessions8.setSessionName("Session 8");
//        sessions8.setProgramName("Program 8");
//        sessions8.setParticipantsCount("40");
//        sessions8.setPresentCountPlayers("8");
//        sessions8.setBatchName("Batch 1");
//        sessions8.setDateTime("12-Sep-18");
//        sessions8.setHour_start("3:30pm");
//        list.add(sessions8);
//
//        Sessions sessions9 = new Sessions();
//        sessions9.setSessionName("Session 9");
//        sessions9.setProgramName("Program 9");
//        sessions9.setParticipantsCount("40");
//        sessions9.setPresentCountPlayers("8");
//        sessions9.setBatchName("Batch 1");
//        sessions9.setDateTime("12-Sep-18");
//        sessions9.setHour_start("3:30pm");
//        list.add(sessions9);
//
//        Sessions sessions10 = new Sessions();
//        sessions10.setSessionName("Session 10");
//        sessions10.setProgramName("Program 10");
//        sessions10.setParticipantsCount("40");
//        sessions10.setPresentCountPlayers("8");
//        sessions10.setBatchName("Batch 1");
//        sessions10.setDateTime("12-Sep-18");
//        sessions10.setHour_start("3:30pm");
//        list.add(sessions10);
//
//        Sessions sessions11 = new Sessions();
//        sessions11.setSessionName("Session 11");
//        sessions11.setProgramName("Program 11");
//        sessions11.setParticipantsCount("40");
//        sessions11.setPresentCountPlayers("8");
//        sessions11.setBatchName("Batch 1");
//        sessions11.setDateTime("12-Sep-18");
//        sessions11.setHour_start("3:30pm");
//        list.add(sessions11);
//
//        Sessions sessions12 = new Sessions();
//        sessions12.setSessionName("Session 12");
//        sessions12.setProgramName("Program 12");
//        sessions12.setParticipantsCount("40");
//        sessions12.setPresentCountPlayers("8");
//        sessions12.setBatchName("Batch 1");
//        sessions12.setDateTime("12-Sep-18");
//        sessions12.setHour_start("3:30pm");
//        list.add(sessions12);
//
//        adapter = new EvalSessionsAdapter(getActivity(), list);
//        sessionsEvalRV.setAdapter(adapter);
//
//    }

}
