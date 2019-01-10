package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.sessions.Sessions;
import in.sashi.sporteco.viewholders.ScheduleSessionsViewHolder;

public class ScheduleSessionsAdapter extends RecyclerView.Adapter<ScheduleSessionsViewHolder> {

    private final Context context;
    private List<Sessions> itemsList;

    public ScheduleSessionsAdapter(Context context, List<Sessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ScheduleSessionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_sessions_items_layout, parent, false);
        return new ScheduleSessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleSessionsViewHolder viewholder, int position) {
        Sessions sessions = itemsList.get(position);
        viewholder.sched_sessionNameTV.setText(sessions.session_name);
        viewholder.sched_drillsTV.setText(sessions.num_sessions_drills);
        Picasso.with(context)
                .load(sessions.session_cover_image)
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.sched_sessionIV);
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}