package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.widget.ImageView;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.NewBatchAdapter;
import in.sashi.sporteco.models.players.Players;

public class NewBatchDialog extends DialogFragment {

    private static final String TAG = NewBatchDialog.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV, searchPlayersIV;
    private Button batchDoneBtn;
    private RecyclerView batchPlayersRV;

    private List<Players> list = new ArrayList<>();
    private NewBatchAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_batch_dialog, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        searchPlayersIV = view.findViewById(R.id.searchPlayersIV);
        batchPlayersRV = view.findViewById(R.id.batchPlayersRV);
        batchDoneBtn = view.findViewById(R.id.batchDoneBtn);

        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setUpPlayers();

        batchDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void setUpPlayers() {
        batchPlayersRV.setHasFixedSize(true);
        batchPlayersRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        populate();

    }

    private void populate() {
        SQLite.select()
                .from(Players.class)
                .async()
                .queryListResultCallback(new QueryTransaction.QueryResultListCallback<Players>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<Players> tResult) {
                        list = tResult;
                        adapter = new NewBatchAdapter(getActivity(), list);
                        batchPlayersRV.setAdapter(adapter);
                        Log.d(TAG, "List Size:\t" + tResult.size());
                    }
                }).execute();

    }
}
