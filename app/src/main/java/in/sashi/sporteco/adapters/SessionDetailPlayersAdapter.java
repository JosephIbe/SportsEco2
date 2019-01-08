package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.players.EvalSessionPlayers;
import in.sashi.sporteco.viewholders.EvalSessionDetailViewHolder;

public class SessionDetailPlayersAdapter extends RecyclerView.Adapter<EvalSessionDetailViewHolder> {

    private static final String TAG = SessionDetailPlayersAdapter.class.getSimpleName();

    private final Context context;
    private List<EvalSessionPlayers> itemsList;

    public SessionDetailPlayersAdapter(Context context, List<EvalSessionPlayers> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public EvalSessionDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eval_session_detail_player_items_layout, parent, false);
        return new EvalSessionDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EvalSessionDetailViewHolder viewholder, int position) {
        final EvalSessionPlayers players = itemsList.get(position);
        viewholder.evalPlayerNameTV.setText(players.firstName + "\t" + players.lastName);
//        Log.d(TAG, "fn:\t" + players.firstName);
        Picasso.with(context)
                .load(players.imageURL)
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.evalPlayerIV);
        viewholder.evalPlayerCB.setOnCheckedChangeListener(null);
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "player name:\t" + players.firstName, Toast.LENGTH_SHORT).show();
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