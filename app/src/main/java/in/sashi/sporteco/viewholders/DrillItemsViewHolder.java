package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class DrillItemsViewHolder extends RecyclerView.ViewHolder {

    public TextView drillNameTV, durationTV, countDownTV;
    public ImageView drillIconIV, favoriteDrillIV, playBtn;
    public RelativeLayout timerLayout;

    public DrillItemsViewHolder(@NonNull View itemView) {
        super(itemView);

        drillNameTV = itemView.findViewById(R.id.drillNameTV);
        durationTV = itemView.findViewById(R.id.durationTV);
        countDownTV = itemView.findViewById(R.id.countDownTV);
        drillIconIV = itemView.findViewById(R.id.drillIconIV);
        favoriteDrillIV = itemView.findViewById(R.id.favoriteDrillIV);
        playBtn = itemView.findViewById(R.id.playBtn);
        timerLayout = itemView.findViewById(R.id.timerLayout);

    }
}
