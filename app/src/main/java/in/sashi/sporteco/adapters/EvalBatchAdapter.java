package in.sashi.sporteco.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Batch;
import in.sashi.sporteco.models.batch.EvalBatch;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.ui.fragments.dialogs.EvalFilterBatchFragment;
import in.sashi.sporteco.ui.fragments.evaluate.EvaluateSessionDetailFragment;
import in.sashi.sporteco.viewholders.EvalBatchViewHolder;

public class EvalBatchAdapter extends RecyclerView.Adapter<EvalBatchViewHolder> {

    private final Context context;
    private List<EvalBatch> itemsList;

    public EvalBatchAdapter(Context context, List<EvalBatch> itemsList) {
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
        final EvalBatch batch = itemsList.get(position);

        holder.batch_nameTV.setText(batch.getBatchName());
        holder.program_nameTV.setText(batch.getProgramName());
        holder.playersCountTV.setText(batch.getPlayersCount());
//        holder.startDateTV.setText(batch.getStartDate());
        holder.startDateTV.setText("Alright, ok");

        holder.evalBatchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EvalFilterBatchFragment fragment = new EvalFilterBatchFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name_batch", batch.getBatchName());
                bundle.putString("id_batch", batch.getBatchId());
                fragment.setArguments(bundle);
                fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar);
                fragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "EvalFilterBatchFragment");
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