package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class ProgramsSessionsViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView program_sessionIV;
    public TextView program_sessionNameTV, program_drillsTV;

    public ProgramsSessionsViewHolder(@NonNull View itemView) {
        super(itemView);

        program_sessionIV = itemView.findViewById(R.id.program_sessionIV);
        program_sessionNameTV = itemView.findViewById(R.id.program_sessionNameTV);
        program_drillsTV = itemView.findViewById(R.id.program_drillsTV);

    }
}
