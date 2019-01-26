package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import in.sashi.sporteco.R;

public class NewPlayerDialog extends DialogFragment {

    private static final String TAG = NewPlayerDialog.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private EditText playerNameET, playerEmailET, playerMobileET;
    private Button playerDoneBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_player_dialog, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        backIV = view.findViewById(R.id.backIV);
        playerNameET = view.findViewById(R.id.playerNameET);
        playerEmailET = view.findViewById(R.id.playerEmailET);
        playerMobileET = view.findViewById(R.id.playerMobileET);
        playerDoneBtn = view.findViewById(R.id.playerDoneBtn);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        playerDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
