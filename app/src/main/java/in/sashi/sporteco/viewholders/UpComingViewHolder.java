package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class UpComingViewHolder extends RecyclerView.ViewHolder {

    public ImageView upcomingIV;
    public TextView upcomingNameTV, dateTimeTV, statusTV, timeTV, dateTV;
    public RelativeLayout rootLayout;

    public UpComingViewHolder(@NonNull View itemView) {
        super(itemView);

        upcomingIV = itemView.findViewById(R.id.upcomingIV);
        upcomingNameTV = itemView.findViewById(R.id.upcomingNameTV);
        dateTimeTV = itemView.findViewById(R.id.dateTimeTV);
        statusTV = itemView.findViewById(R.id.statusTV);
        rootLayout = itemView.findViewById(R.id.rootLayout);

    }
}
