package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    public ImageView historyIV;
    public TextView historyNameTV, historyDateTimeTV;
    public RelativeLayout rootLayout;

    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);

        historyIV = itemView.findViewById(R.id.historyIV);
        historyNameTV = itemView.findViewById(R.id.historyNameTV);
        historyDateTimeTV = itemView.findViewById(R.id.historyDateTimeTV);
        rootLayout = itemView.findViewById(R.id.rootLayout);

    }
}
