package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class SkillsPlayersViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView skillsPlayerIV;
    public TextView skillsPlayerNameTV;
    public CheckBox skillsPlayerCB;

    public SkillsPlayersViewHolder(@NonNull View itemView) {
        super(itemView);

        skillsPlayerIV = itemView.findViewById(R.id.skillsPlayerIV);
        skillsPlayerNameTV = itemView.findViewById(R.id.skillsPlayerNameTV);
        skillsPlayerCB = itemView.findViewById(R.id.skillsPlayerCB);

    }

}
