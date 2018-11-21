package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.HomeActions;
import in.sashi.sporteco.viewholders.ActionsViewHolder;

public class ActionsAdapter extends RecyclerView.Adapter<ActionsViewHolder> {

    private final Context context;
    private List<HomeActions> itemsList;

    public ActionsAdapter(Context context, List<HomeActions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ActionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_actions_items_layout, parent, false);
        return new ActionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActionsViewHolder viewholder, int position) {
        HomeActions actions = itemsList.get(position);
        viewholder.actionTxt.setText(actions.getActionName());
        viewholder.actionIV.setImageResource(actions.getImg());
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}