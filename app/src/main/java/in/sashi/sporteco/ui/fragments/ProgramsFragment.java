package in.sashi.sporteco.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import in.sashi.sporteco.R;
import in.sashi.sporteco.utils.EmptyRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramsFragment extends Fragment {

    private static final String TAG = ProgramsFragment.class.getSimpleName();

    private EmptyRecyclerView groupsRV;
    private RelativeLayout emptyState;
    private FloatingActionButton groupsFAB;

    public ProgramsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_programs, container, false);

        init(v);
        groupsRV.setEmptyView(emptyState);

        setUpRV();

        return v;
    }

    private void setUpRV() {
        groupsRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setStackFromEnd(true);
        llm.setReverseLayout(true);
        groupsRV.setLayoutManager(llm);
    }

    private void init(View view) {
        groupsRV = view.findViewById(R.id.groupsRV);
        emptyState = view.findViewById(R.id.emptyState);
        groupsFAB = view.findViewById(R.id.groupsFAB);
    }

}
