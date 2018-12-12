package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class AddGroupFragment extends DialogFragment implements View.OnClickListener {

    private static final String TAG = AddGroupFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;
    private EditText groupNameET;
    private TextView numSelectedTV;
    private FloatingActionButton proceedFAB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_group, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        groupNameET = view.findViewById(R.id.groupNameET);
        proceedFAB = view.findViewById(R.id.proceedFAB);
        numSelectedTV = view.findViewById(R.id.numSelectedTV);

        closeIV.setOnClickListener(this);
        proceedFAB.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.closeIV:
                dismiss();
                break;
            case R.id.proceedFAB:
                // TODO: 12/11/2018 validate inputs
                break;
        }
    }
}
