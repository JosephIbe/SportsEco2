package in.sashi.sporteco.ui.fragments.evaluate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.EvalBatchAdapter;
import in.sashi.sporteco.models.app.Batch;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvalBatchFragment extends Fragment {

    private static final String TAG = EvalBatchFragment.class.getSimpleName();

    private RecyclerView rv;
    private List<Batch> list = new ArrayList<>();
    private EvalBatchAdapter adapter;

    public EvalBatchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eval_batch, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        rv = view.findViewById(R.id.batchListRV);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        populate();

    }

    private void populate() {
        Batch batch = new Batch();
        batch.setBatchId("");//from server
        batch.setBatchName("Batch 0");
        batch.setProgramName("Program 0");
        batch.setPlayersCount("23");
        batch.setStartDate("12-Oct-18");
        list.add(batch);

        Batch batch1 = new Batch();
        batch1.setBatchId("");//from server
        batch1.setBatchName("Batch 1");
        batch1.setProgramName("Program 1");
        batch1.setPlayersCount("23");
        batch1.setStartDate("12-Oct-18");
        list.add(batch1);

        Batch batch2 = new Batch();
        batch.setBatchId("");//from server
        batch2.setBatchName("Batch 2");
        batch2.setProgramName("Program 2");
        batch2.setPlayersCount("23");
        batch2.setStartDate("12-Oct-18");
        list.add(batch2);

        Batch batch3 = new Batch();
        batch3.setBatchId("");//from server
        batch3.setBatchName("Batch 3");
        batch3.setProgramName("Program 3");
        batch3.setPlayersCount("23");
        batch3.setStartDate("12-Oct-18");
        list.add(batch3);

        Batch batch4 = new Batch();
        batch4.setBatchId("");//from server
        batch4.setBatchName("Batch 4");
        batch4.setProgramName("Program 4");
        batch4.setPlayersCount("23");
        batch4.setStartDate("12-Oct-18");
        list.add(batch4);

        Batch batch5 = new Batch();
        batch5.setBatchId("");//from server
        batch5.setBatchName("Batch 5");
        batch5.setProgramName("Program 5");
        batch5.setPlayersCount("23");
        batch5.setStartDate("12-Oct-18");
        list.add(batch5);

        Batch batch6 = new Batch();
        batch6.setBatchId("");//from server
        batch6.setBatchName("Batch 6");
        batch6.setProgramName("Program 6");
        batch6.setPlayersCount("23");
        batch6.setStartDate("12-Oct-18");
        list.add(batch6);

        Batch batch7 = new Batch();
        batch7.setBatchId("");//from server
        batch7.setBatchName("Batch 7");
        batch7.setProgramName("Program 7");
        batch7.setPlayersCount("23");
        batch7.setStartDate("12-Oct-18");
        list.add(batch7);

        Batch batch8 = new Batch();
        batch8.setBatchId("");//from server
        batch8.setBatchName("Batch 8");
        batch8.setProgramName("Program 8");
        batch8.setPlayersCount("23");
        batch8.setStartDate("12-Oct-18");
        list.add(batch8);

        Batch batch9 = new Batch();
        batch9.setBatchId("");//from server
        batch9.setBatchName("Batch 9");
        batch9.setProgramName("Program 9");
        batch9.setPlayersCount("91");
        batch9.setStartDate("12-Oct-18");
        list.add(batch9);

        Batch batch10 = new Batch();
        batch10.setBatchId("");//from server
        batch10.setBatchName("Batch 10");
        batch10.setProgramName("Program 10");
        batch10.setPlayersCount("25");
        batch10.setStartDate("12-Oct-18");
        list.add(batch10);

        Batch batch11 = new Batch();
        batch11.setBatchId("");//from server
        batch11.setBatchName("Batch 11");
        batch11.setProgramName("Program 11");
        batch11.setPlayersCount("34");
        batch11.setStartDate("12-Oct-18");
        list.add(batch11);

        Batch batch12 = new Batch();
        batch12.setBatchId("");//from server
        batch12.setBatchName("Batch 12");
        batch12.setProgramName("Program 12");
        batch12.setPlayersCount("231");
        batch12.setStartDate("12-Oct-18");
        list.add(batch12);

        adapter = new EvalBatchAdapter(getActivity(), list);
        rv.setAdapter(adapter);

    }

}
