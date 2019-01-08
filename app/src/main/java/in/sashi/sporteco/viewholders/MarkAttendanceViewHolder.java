package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class MarkAttendanceViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout playerAvatarLayout;
    public CircleImageView playerAvatarIV;
    public CheckBox checkBoxPlayer;
    public TextView namePlayerTV;

    public MarkAttendanceViewHolder(@NonNull View itemView) {
        super(itemView);

        playerAvatarLayout = itemView.findViewById(R.id.playerAvatarLayout);
        playerAvatarIV = itemView.findViewById(R.id.playerAvatarIV);
        checkBoxPlayer = itemView.findViewById(R.id.checkBoxPlayer);
        namePlayerTV = itemView.findViewById(R.id.namePlayerTV);

    }
}
