package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class ScheduleSessionsViewHolder extends RecyclerView.ViewHolder{

    public CircleImageView sched_sessionIV;
    public TextView sched_sessionNameTV, sched_drillsTV;
    public CheckBox schedSessionCheckbox;

    public ScheduleSessionsViewHolder(@NonNull View itemView) {
        super(itemView);

        sched_sessionIV = itemView.findViewById(R.id.sched_sessionIV);
        sched_sessionNameTV = itemView.findViewById(R.id.sched_sessionNameTV);
        sched_drillsTV = itemView.findViewById(R.id.sched_drillsTV);
        schedSessionCheckbox = itemView.findViewById(R.id.schedSessionCheckbox);

    }
}
