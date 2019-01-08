package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.sessions.UpComingSessions;
import in.sashi.sporteco.viewholders.UpComingViewHolder;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingViewHolder> {

    private final Context context;
    private List<UpComingSessions> itemsList;

    public UpComingAdapter(Context context, List<UpComingSessions> itemsList) {
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
        UpComingSessions sessions = itemsList.get(position);
        viewholder.upcomingNameTV.setText(sessions.getSessionName());

        viewholder.upcomingNameTV.setText(sessions.getSessionName());
//        viewholder.numSessionsUpcomingTV.setText(sessions.getNumSessions_Drills());
        viewholder.upcomingBatchNameTV.setText(sessions.getBatchName());
        viewholder.upcomingProgramNameTV.setText(sessions.getProgram_name());
        viewholder.upcoming_present_countTV.setText(sessions.getPresent_count());
        viewholder.upcoming_total_countTV.setText(sessions.getPlayers_count());
        viewholder.upcoming_timeTV.setText(sessions.getHour_start());
        viewholder.upcoming_dateTV.setText(sessions.getDate_start());

//        viewholder.rootLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Clicked a position " + position, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}