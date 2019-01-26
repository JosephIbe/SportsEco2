package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.FocusPoints;
import in.sashi.sporteco.viewholders.FocusPointsViewHolder;

public class FocusPointsAdapter extends RecyclerView.Adapter<FocusPointsViewHolder> {

    private final Context context;
    private List<FocusPoints> itemsList;

    public FocusPointsAdapter(Context context, List<FocusPoints> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public FocusPointsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.focus_pts_items_layout, parent, false);
        return new FocusPointsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FocusPointsViewHolder viewholder, int position) {
        FocusPoints points = itemsList.get(position);
        viewholder.focusTV.setText(points.getTitle());
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}