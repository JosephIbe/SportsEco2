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
public class PresentFragment extends Fragment {

    private static final String TAG = PresentFragment.class.getSimpleName();

    private EmptyRecyclerView presentRV;
    private LinearLayout emptyPlayersState;

    public PresentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_present, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        emptyPlayersState = view.findViewById(R.id.emptyPlayersState);
        presentRV = view.findViewById(R.id.presentRV);

        presentRV.setHasFixedSize(true);
        presentRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        presentRV.setEmptyView(emptyPlayersState);
    }

}
