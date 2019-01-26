package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class MySessionsViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView mySessionIV;
    public TextView mySessionNameTV;
    public CheckBox checkBoxSelect;

    public MySessionsViewHolder(@NonNull View itemView) {
        super(itemView);
        mySessionIV = itemView.findViewById(R.id.mySessionIV);
        mySessionNameTV = itemView.findViewById(R.id.mySessionNameTV);
        checkBoxSelect = itemView.findViewById(R.id.checkBoxSelect);
    }
}
