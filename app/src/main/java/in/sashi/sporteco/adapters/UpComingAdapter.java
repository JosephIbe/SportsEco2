package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Sessions;
import in.sashi.sporteco.viewholders.UpComingViewHolder;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingViewHolder> {

    private final Context context;
    private List<Sessions> itemsList;

    public UpComingAdapter(Context context, List<Sessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public UpComingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_sessions_items_layout
                , parent, false);
        return new UpComingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UpComingViewHolder viewholder, final int position) {
        Sessions sessions = itemsList.get(position);
        viewholder.upcomingNameTV.setText(sessions.getSessionName());
        viewholder.dateTimeTV.setText(sessions.getDateTime());
        viewholder.statusTV.setText(sessions.getStatus());

        Picasso.with(context)
                .load(sessions.getSessionIcon())
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.upcomingIV);

        viewholder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked a position " + position, Toast.LENGTH_SHORT).show();
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