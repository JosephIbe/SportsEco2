package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Batch;
import in.sashi.sporteco.viewholders.EvalBatchViewHolder;

public class EvalBatchAdapter extends RecyclerView.Adapter<EvalBatchViewHolder> {

    private final Context context;
    private List<Batch> itemsList;

    public EvalBatchAdapter(Context context, List<Batch> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public EvalBatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eval_batch_items_layout, parent, false);
        return new EvalBatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EvalBatchViewHolder holder, int position) {
        Batch batch = itemsList.get(position);

        holder.batch_nameTV.setText(batch.getBatchName());
        holder.program_nameTV.setText(batch.getProgramName());
        holder.playersCountTV.setText(batch.getPlayersCount());
        holder.startDateTV.setText(batch.getStartDate());

        holder.evalBatchlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}