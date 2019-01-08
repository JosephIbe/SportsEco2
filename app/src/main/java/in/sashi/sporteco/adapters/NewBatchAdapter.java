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
import in.sashi.sporteco.viewholders.NewBatchViewHolder;

public class NewBatchAdapter extends RecyclerView.Adapter<NewBatchViewHolder> {

    private final Context context;
    private List<Players> itemsList;

    public NewBatchAdapter(Context context, List<Players> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public NewBatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_batch_items_layout, parent, false);
        return new NewBatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NewBatchViewHolder viewholder, int position) {
        Players players = itemsList.get(position);
        viewholder.namePlayerTV.setText(players.firstName + " " + players.lastName);
        Picasso.with(context)
                .load(players.imageURL)
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.player_CIV);

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewholder.checkPlayer_batch.setVisibility(viewholder.checkPlayer_batch.getVisibility() ? View.VISIBLE : View.INVISIBLE);
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