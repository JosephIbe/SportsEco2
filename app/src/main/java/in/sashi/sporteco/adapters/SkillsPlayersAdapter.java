package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.viewholders.SkillsPlayersViewHolder;

public class SkillsPlayersAdapter extends RecyclerView.Adapter<SkillsPlayersViewHolder> {

    private final Context context;
    private List<Players> itemsList;

    public SkillsPlayersAdapter(Context context, List<Players> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public SkillsPlayersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skills_players_items_layout, parent, false);
        return new SkillsPlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SkillsPlayersViewHolder viewholder, int position) {
        Players players = itemsList.get(position);

        Picasso.with(context)
                .load(players.imageURL)
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.skillsPlayerIV);

        viewholder.skillsPlayerNameTV.setText(players.firstName + " " + players.lastName);

        // TODO: 1/7/2019 Handle Check changes

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}