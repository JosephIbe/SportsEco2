package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class PlayersViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView playerCIV;
    public TextView playerNameTV, playerBatchTV;
    public RelativeLayout playerRootLayout;

    public PlayersViewHolder(@NonNull View itemView) {
        super(itemView);

        playerRootLayout = itemView.findViewById(R.id.playerRootLayout);
        playerCIV = itemView.findViewById(R.id.playerCIV);
        playerNameTV = itemView.findViewById(R.id.playerNameTV);
        playerBatchTV = itemView.findViewById(R.id.playerBatchTV);

    }
}
