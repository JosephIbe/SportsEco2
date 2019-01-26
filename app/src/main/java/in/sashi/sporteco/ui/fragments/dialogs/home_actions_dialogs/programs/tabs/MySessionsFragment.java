package in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs.tabs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.MySessionsAdapter;
import in.sashi.sporteco.models.sessions.Sessions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MySessionsFragment extends Fragment {

    private static final String TAG = MySessionsFragment.class.getSimpleName();
    private RecyclerView mySessionsRV;
    private List<Sessions> list = new ArrayList<>();

    public MySessionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_sessions, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        mySessionsRV = view.findViewById(R.id.mySessionsRV);

        mySessionsRV.setHasFixedSize(true);
        mySessionsRV.setLayoutManager(new GridLayoutManager(getActivity(), 3));

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
                        mySessionsRV.setAdapter(new MySessionsAdapter(getActivity(), list));
                    }
                }).execute();
    }

}
