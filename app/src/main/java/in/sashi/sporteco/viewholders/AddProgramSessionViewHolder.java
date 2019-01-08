package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class AddProgramSessionViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView add_program_sessionIV;
    public TextView add_program_sessionNameTV;

    public AddProgramSessionViewHolder(@NonNull View itemView) {
        super(itemView);

        add_program_sessionIV = itemView.findViewById(R.id.add_program_sessionIV);
        add_program_sessionNameTV = itemView.findViewById(R.id.add_program_sessionNameTV);

    }
}
