package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ScheduleSessionsAdapter;
import in.sashi.sporteco.models.sessions.Sessions;

public class NewScheduleDialog extends DialogFragment {

    private static final String TAG = NewScheduleDialog.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private Button schedDoneBtn;

    private RecyclerView scheduleSessionsRV;
    private List<Sessions> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_schedule_dialog, container, false);
        init(view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        backIV = view.findViewById(R.id.backIV);
        scheduleSessionsRV = view.findViewById(R.id.scheduleSessionsRV);
        schedDoneBtn = view.findViewById(R.id.schedDoneBtn);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setUpSessionsRV();

        schedDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "What Next?", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setUpSessionsRV() {
        scheduleSessionsRV.setHasFixedSize(true);
        scheduleSessionsRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        populate();

    }

    private void populate() {
        SQLite.select()
                .from(Sessions.class)
                .async()
                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Sessions>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<Sessions> tResult) {
                        list = tResult;
                        scheduleSessionsRV.setAdapter(new ScheduleSessionsAdapter(getActivity(), list));
                    }
                }).execute();
    }
}
