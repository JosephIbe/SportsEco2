package in.sashi.sporteco.ui.fragments.evaluate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;

import in.sashi.sporteco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SessionsBasedFragment extends Fragment {

    private static final String TAG = SessionsBasedFragment.class.getSimpleName();

    private RatingBar sessRatingBar;
    private EditText commentsBox;

    public SessionsBasedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sessions_based, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        sessRatingBar = view.findViewById(R.id.sessRatingBar);
        commentsBox = view.findViewById(R.id.commentsBox);

        double value = sessRatingBar.getRating();
        String feedback = commentsBox.getText().toString();

    }

}
