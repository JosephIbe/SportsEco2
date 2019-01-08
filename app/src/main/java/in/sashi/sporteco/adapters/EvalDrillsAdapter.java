package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.drills.EvalDrills;
import in.sashi.sporteco.viewholders.EvalDrillItemsViewHolder;

public class EvalDrillsAdapter extends RecyclerView.Adapter<EvalDrillItemsViewHolder> {

    private final Context context;
    private List<EvalDrills> itemsList;

    public EvalDrillsAdapter(Context context, List<EvalDrills> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public EvalDrillItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eval_drills_items_layout, parent, false);
        return new EvalDrillItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EvalDrillItemsViewHolder viewholder, final int position) {
        final EvalDrills drills = itemsList.get(position);
        viewholder.bind(drills, context);
//        Picasso.with(context)
//                .load(drills.getProgDrillImg())
//                .placeholder(R.drawable.app_logo_resized)
//                .into(viewholder.evalDrillCIV);
//        viewholder.evalDrillNameTV.setText(drills.getProgDrillName());
//        viewholder.evalDrillDurationTV.setText(drills.getProgDrillDurn());

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExpanded = drills.isExpanded();
                drills.setExpanded(!isExpanded);
                notifyItemChanged(position);
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