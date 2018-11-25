package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class SessionsViewHolder extends RecyclerView.ViewHolder {

    public CardView sessCardHolder;
    public ImageView sessionIV;
    public TextView sessionNameTV, programNameTV, batchNameTV, countTV;

    public SessionsViewHolder(@NonNull View itemView) {
        super(itemView);

        sessCardHolder = itemView.findViewById(R.id.sessCardHolder);
        sessionIV = itemView.findViewById(R.id.sessionIV);
        sessionNameTV = itemView.findViewById(R.id.sessionNameTV);
        programNameTV = itemView.findViewById(R.id.programNameTV);
        batchNameTV = itemView.findViewById(R.id.batchNameTV);
        countTV = itemView.findViewById(R.id.countTV);

    }
}
