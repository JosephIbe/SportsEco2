package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs.drills;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.sashi.sporteco.R;

public class MyDrills extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_drills, container, false);
        init(view);
        return view;
    }

    private void init(View view) { }
}
