package in.sashi.sporteco.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.UpComingAdapter;
import in.sashi.sporteco.models.app.Sessions;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpComingFragment extends Fragment {

    private static final String TAG = UpComingFragment.class.getSimpleName();

    private RecyclerView upComingRV;
    private ProgressBar progress;

    private UpComingAdapter adapter;
    private List<Sessions> sessionsList = new ArrayList<>();

    public UpComingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_up_coming, container, false);

        initViews(view);

        return view;
    }

    private void mockSessions() {
        Sessions item1 = new Sessions();
        item1.setSessionIcon(R.drawable.ic_home);
        item1.setSessionName("Session 1");
        item1.setStatus("Ongoing");
        item1.setDateTime("31-10-18 05:29");
        sessionsList.add(item1);

        Sessions item2 = new Sessions();
        item2.setSessionIcon(R.drawable.ic_home);
        item2.setSessionName("Session 2");
        item2.setStatus("00: 45");
        item2.setDateTime("31-10-18 06:34");
        sessionsList.add(item2);

        Sessions item3 = new Sessions();
        item3.setSessionIcon(R.drawable.ic_home);
        item3.setSessionName("Session 3");
        item3.setStatus("1d, 4hrs");
        item3.setDateTime("01-11-18 08:29");
        sessionsList.add(item3);

        Sessions item4 = new Sessions();
        item4.setSessionIcon(R.drawable.ic_home);
        item4.setSessionName("Session 4");
        item4.setStatus("1d, 9hrs");
        item4.setDateTime("01-11-18 13:29");
        sessionsList.add(item4);

        Sessions item5 = new Sessions();
        item5.setSessionIcon(R.drawable.ic_home);
        item5.setSessionName("Session 5");
        item5.setStatus("1d, 11hrs");
        item5.setDateTime("01-11-18 15:29");
        sessionsList.add(item5);

        Sessions item6 = new Sessions();
        item6.setSessionIcon(R.drawable.ic_home);
        item6.setSessionName("Session 6");
        item6.setStatus("2d, 9hrs");
        item6.setDateTime("02-11-18 13:29");
        sessionsList.add(item6);

        Sessions item7 = new Sessions();
        item7.setSessionIcon(R.drawable.ic_home);
        item7.setSessionName("Session 7");
        item7.setStatus("5d, 14hrs");
        item7.setDateTime("06-11-18 18:29");
        sessionsList.add(item4);

        adapter = new UpComingAdapter(getActivity(), sessionsList);
        upComingRV.setAdapter(adapter);

    }

    private void initViews(View view) {
        upComingRV = view.findViewById(R.id.upComingRV);

        progress = view.findViewById(R.id.progress);
        progress.setVisibility(View.GONE);

        upComingRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        upComingRV.setLayoutManager(llm);
        upComingRV.addItemDecoration(new DividerItemDecoration(getActivity(), llm.getOrientation()));

        mockSessions();

    }

}
