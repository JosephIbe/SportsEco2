package in.sashi.sporteco.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.ui.fragments.players.PlayerInfoFragment;
import in.sashi.sporteco.viewholders.PlayersViewHolder;

import static in.sashi.sporteco.utils.Constants.PLAYER_KEY_USER_ID;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersViewHolder> {

    private final Context context;
    private List<Players> itemsList;

    public PlayersAdapter(Context context, List<Players> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public PlayersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_items_layout, parent, false);
        return new PlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayersViewHolder viewholder, int position) {
        final Players players = itemsList.get(position);
        viewholder.playerNameTV.setText(players.getFirstName() + " " + players.getLastName());
        viewholder.playerBatchTV.setText(players.getBatchPlayer());
        Picasso.with(context)
                .load(players.getImageURL())
                .placeholder(R.drawable.app_logo_resized)
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.playerCIV);

        viewholder.playerRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerInfoFragment fragment = new PlayerInfoFragment();
                Bundle bundle = new Bundle();
//                bundle.putString(PLAYER_KEY_IMAGE_URL, players.getImageURL());
//                String fullName = players.getFirstName() + " " + players.getLastName();
//                bundle.putString(PLAYER_KEY_NAME, fullName);
//                bundle.putString(PLAYER_KEY_ADDRESS, players.getAddress());
//                bundle.putString(PLAYER_KEY_STATE, players.getStatePlayer());
                bundle.putString(PLAYER_KEY_USER_ID, players.getUserId());
                fragment.setArguments(bundle);
                fragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "PlayerInfoFragment");
            }
        });

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}