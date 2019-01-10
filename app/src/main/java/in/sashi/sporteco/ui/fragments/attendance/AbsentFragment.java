package in.sashi.sporteco.ui.fragments.attendance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import in.sashi.sporteco.R;
import in.sashi.sporteco.utils.EmptyRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AbsentFragment extends Fragment {

    private static final String TAG = AbsentFragment.class.getSimpleName();

    private LinearLayout emptyPlayersState;
    private EmptyRecyclerView absentRV;

    public AbsentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_absent, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        emptyPlayersState = view.findViewById(R.id.emptyPlayersState);
        absentRV = view.findViewById(R.id.absentRV);

        absentRV.setHasFixedSize(true);
        absentRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        absentRV.setEmptyView(emptyPlayersState);
    }

}
