package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    public ImageView historyIV;
    public TextView historyNameTV, numSessionsHistoryTV, historyBatchNameTV,
            historyProgramNameTV, history_present_countTV, history_total_countTV, history_timeTV, history_dateTV;
    public LinearLayout rootLayout;

    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);

        historyIV = itemView.findViewById(R.id.historyIV);
        historyNameTV = itemView.findViewById(R.id.historyNameTV);
        numSessionsHistoryTV = itemView.findViewById(R.id.numSessionsHistoryTV);
        historyBatchNameTV = itemView.findViewById(R.id.historyBatchNameTV);
        historyProgramNameTV = itemView.findViewById(R.id.historyProgramNameTV);
        history_present_countTV = itemView.findViewById(R.id.history_present_countTV);
        history_total_countTV = itemView.findViewById(R.id.history_total_countTV);
        history_timeTV = itemView.findViewById(R.id.history_timeTV);
        history_dateTV = itemView.findViewById(R.id.history_dateTV);
        rootLayout = itemView.findViewById(R.id.rootLayout);

    }
}
