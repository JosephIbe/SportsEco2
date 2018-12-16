package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class UpComingViewHolder extends RecyclerView.ViewHolder {

    public ImageView upcomingIV;
    public TextView upcomingNameTV,  numSessionsUpcomingTV, upcomingBatchNameTV,
            upcomingProgramNameTV, upcoming_present_countTV, upcoming_total_countTV, upcoming_timeTV, upcoming_dateTV;
    public LinearLayout rootLayout;

    public UpComingViewHolder(@NonNull View itemView) {
        super(itemView);

        upcomingIV = itemView.findViewById(R.id.upcomingIV);
        upcomingNameTV = itemView.findViewById(R.id.upcomingNameTV);
        numSessionsUpcomingTV = itemView.findViewById(R.id.numSessionsUpcomingTV);
        upcomingBatchNameTV = itemView.findViewById(R.id.upcomingBatchNameTV);
        upcomingProgramNameTV = itemView.findViewById(R.id.upcomingProgramNameTV);
        upcoming_present_countTV = itemView.findViewById(R.id.upcoming_present_countTV);
        upcoming_total_countTV = itemView.findViewById(R.id.upcoming_total_countTV);
        upcoming_timeTV = itemView.findViewById(R.id.upcoming_timeTV);
        upcoming_dateTV = itemView.findViewById(R.id.upcoming_dateTV);
        rootLayout = itemView.findViewById(R.id.rootLayout);

    }
}
