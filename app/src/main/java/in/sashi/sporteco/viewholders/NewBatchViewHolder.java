package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class NewBatchViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView player_CIV;
    public TextView namePlayerTV;
    public CheckBox checkPlayer_batch;

    public NewBatchViewHolder(@NonNull View itemView) {
        super(itemView);
        player_CIV = itemView.findViewById(R.id.player_CIV);
        namePlayerTV = itemView.findViewById(R.id.namePlayer_TV);
        checkPlayer_batch = itemView.findViewById(R.id.checkPlayer_batch);
    }
}
