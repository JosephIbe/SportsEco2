package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.AddSessionsProgramAdapter;
import in.sashi.sporteco.models.app.AdapterHeaderItem;
import in.sashi.sporteco.models.sessions.Sessions;

public class NewProgramDialog extends DialogFragment {

    private static final String TAG = NewProgramDialog.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;

    private EditText progNameET, placeTV, descET;
    private Button programDoneBtn;

    private RecyclerView addProgramSessionsRV;
    private List<Object> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_program_dialog, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        backIV = view.findViewById(R.id.backIV);
        progNameET = view.findViewById(R.id.progNameET);
        placeTV = view.findViewById(R.id.placeTV);
        descET = view.findViewById(R.id.descET);
        programDoneBtn = view.findViewById(R.id.programDoneBtn);
        addProgramSessionsRV = view.findViewById(R.id.addProgramSessionsRV);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        populateSessions();

        programDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 1/8/2019 validate
                Toast.makeText(getActivity(), "What Next?", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void populateSessions() {

        addProgramSessionsRV.setHasFixedSize(true);
        addProgramSessionsRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        AdapterHeaderItem headerItem = new AdapterHeaderItem();
        headerItem.setHeaderTitle("Add Session");
        list.add(headerItem);

        SQLite.select()
                .from(Sessions.class)
                .async()
                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Sessions>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<Sessions> tResult) {
//                        list.add(tResult);
                        addProgramSessionsRV.setAdapter(new AddSessionsProgramAdapter(getActivity(), list));
                    }
                }).execute();

    }
}
