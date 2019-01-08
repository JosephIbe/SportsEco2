package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class EvalSessionDetailViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView evalPlayerIV;
    public TextView evalPlayerNameTV;
    public CheckBox evalPlayerCB;

    public EvalSessionDetailViewHolder(@NonNull View itemView) {
        super(itemView);

        evalPlayerIV = itemView.findViewById(R.id.evalPlayerIV);
        evalPlayerNameTV = itemView.findViewById(R.id.evalPlayerNameTV);
        evalPlayerCB = itemView.findViewById(R.id.evalPlayerCB);

    }
}
