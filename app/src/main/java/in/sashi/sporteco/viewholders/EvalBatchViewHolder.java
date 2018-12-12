package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class EvalBatchViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout evalBatchLayout;
    public TextView batch_nameTV, program_nameTV, startDateTV, playersCountTV;

    public EvalBatchViewHolder(@NonNull View itemView) {
        super(itemView);

        evalBatchLayout = itemView.findViewById(R.id.evalBatchLayout);
        batch_nameTV = itemView.findViewById(R.id.batch_nameTV);
        program_nameTV = itemView.findViewById(R.id.program_nameTV);
        startDateTV = itemView.findViewById(R.id.startDateTV);
        playersCountTV = itemView.findViewById(R.id.playersCountTV);

    }
}
