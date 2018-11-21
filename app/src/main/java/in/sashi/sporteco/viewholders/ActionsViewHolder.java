package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class ActionsViewHolder extends RecyclerView.ViewHolder {

    public TextView actionTxt;
    public ImageView actionIV;

    public ActionsViewHolder(@NonNull View itemView) {
        super(itemView);

        actionIV = itemView.findViewById(R.id.actionIV);
        actionTxt = itemView.findViewById(R.id.actionTxt);

    }
}
