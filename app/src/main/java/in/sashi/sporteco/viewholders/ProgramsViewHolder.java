package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class ProgramsViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView programsCIV;
    public TextView programTV, sessionProgramsTV, dateProgramsTV;

    public ProgramsViewHolder(@NonNull View itemView) {
        super(itemView);

        programsCIV = itemView.findViewById(R.id.programsCIV);
        programTV = itemView.findViewById(R.id.programTV);
        sessionProgramsTV = itemView.findViewById(R.id.sessionProgramsTV);
        dateProgramsTV = itemView.findViewById(R.id.dateProgramsTV);

    }
}
