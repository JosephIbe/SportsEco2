package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class CalendarSessionsViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView cal_sessionCIV;
    public TextView cal_sessionNameTV, cal_timeTV, cal_programNameTV, cal_batchTV, cal_sessionCountTV;

    public CalendarSessionsViewHolder(@NonNull View itemView) {
        super(itemView);

        cal_sessionNameTV = itemView.findViewById(R.id.cal_sessionNameTV);
        cal_timeTV = itemView.findViewById(R.id.cal_timeTV);
        cal_programNameTV = itemView.findViewById(R.id.cal_programNameTV);
        cal_batchTV = itemView.findViewById(R.id.cal_batchTV);
        cal_sessionCountTV = itemView.findViewById(R.id.cal_sessionCountTV);

    }
}
