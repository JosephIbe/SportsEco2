package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class EvalFilterBatchFragment extends DialogFragment implements View.OnClickListener {

    private static final String TAG = EvalFilterBatchFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;
    private TextView batch_nameTV, detail_player_nameTV;
    private RecyclerView evalBatchPlayersRV;

    private RatingBar batchRatingBar;
    private EditText commentsBox_batch;
    private Button doneBtn;

    private LinearLayout doneLayout;
    private RelativeLayout rootLayout_batch;
    private String bid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eval_batch_detail, container, false);

        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        evalBatchPlayersRV = view.findViewById(R.id.evalBatchPlayersRV);
        batch_nameTV = view.findViewById(R.id.batch_nameTV);
        detail_player_nameTV = view.findViewById(R.id.detail_player_nameTV);
        doneBtn = view.findViewById(R.id.doneBtn);
        rootLayout_batch = view.findViewById(R.id.rootLayout_batch);

        Log.d(TAG, "Name:\t" + getArguments().getString("name_batch"));
        String name = getArguments().getString("name_batch");
        bid = getArguments().getString("id_batch");
        batch_nameTV.setText(name);

        closeIV.setOnClickListener(this);
        doneBtn.setOnClickListener(this);
//        doneLayout.setOnClickListener(this);

        setUpPlayersRV();

    }

    private void setUpPlayersRV() {
        evalBatchPlayersRV.setHasFixedSize(true);
        LinearLayoutManager hlm = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        evalBatchPlayersRV.setLayoutManager(hlm);

//        fetchPlayersFromDB(bid);
        // TODO: 1/7/2019 Get Players based on batch id

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.closeIV:
                dismiss();
                break;
            case R.id.doneBtn:
                // TODO: 12/11/2018 Get User Input
                Snackbar.make(rootLayout_batch, "What next???", Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}
