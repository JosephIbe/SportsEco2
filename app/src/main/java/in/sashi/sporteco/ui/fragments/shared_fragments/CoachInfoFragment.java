package in.sashi.sporteco.ui.fragments.shared_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.sashi.sporteco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoachInfoFragment extends Fragment {


    public CoachInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coach, container, false);
    }

}
