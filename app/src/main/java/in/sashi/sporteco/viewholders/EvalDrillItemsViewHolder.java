package in.sashi.sporteco.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;
import in.sashi.sporteco.models.drills.EvalDrills;

public class EvalDrillItemsViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView evalDrillCIV;
    public TextView evalDrillNameTV, evalDrillDurationTV;
    public LinearLayout subItemsLayout;

    public EvalDrillItemsViewHolder(@NonNull View itemView) {
        super(itemView);

        evalDrillCIV = itemView.findViewById(R.id.evalDrillCIV);
        evalDrillNameTV = itemView.findViewById(R.id.evalDrillNameTV);
        evalDrillDurationTV = itemView.findViewById(R.id.evalDrillDurationTV);
        subItemsLayout = itemView.findViewById(R.id.subItemsLayout);

    }

    public void bind(EvalDrills drills, Context context) {
        Picasso.with(context)
                .load(drills.getProgDrillImg())
                .placeholder(R.drawable.app_logo_resized)
                .into(evalDrillCIV);
        evalDrillNameTV.setText(drills.getProgDrillName());
        evalDrillDurationTV.setText(drills.getProgDrillDurn());
        subItemsLayout.setVisibility(drills.isExpanded() ? View.VISIBLE : View.GONE);
    }
}
