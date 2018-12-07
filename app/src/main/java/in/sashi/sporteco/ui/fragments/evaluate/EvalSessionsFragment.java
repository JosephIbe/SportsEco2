package in.sashi.sporteco.ui.fragments.evaluate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.sashi.sporteco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvalSessionsFragment extends Fragment {

    private static final String TAG = EvalSessionsFragment.class.getSimpleName();

    private RecyclerView sessionsEvalRV;

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

        mockList();

    }

    private void mockList() {

    }

}
