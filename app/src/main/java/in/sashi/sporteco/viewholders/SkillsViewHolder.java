package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class SkillsViewHolder extends RecyclerView.ViewHolder {

    public TextView nameSkill;

    public SkillsViewHolder(@NonNull View itemView) {
        super(itemView);

        nameSkill = itemView.findViewById(R.id.nameSkillTV);

    }
}
