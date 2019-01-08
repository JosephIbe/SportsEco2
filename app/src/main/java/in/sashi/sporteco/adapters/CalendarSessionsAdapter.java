package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.sessions.CalendarSessions;
import in.sashi.sporteco.viewholders.CalendarSessionsViewHolder;

public class CalendarSessionsAdapter extends RecyclerView.Adapter<CalendarSessionsViewHolder> {

    private final Context context;
    private List<CalendarSessions> itemsList;

    public CalendarSessionsAdapter(Context context, List<CalendarSessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public CalendarSessionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_session_items_layout, parent, false);
        return new CalendarSessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CalendarSessionsViewHolder viewholder, int position) {
        CalendarSessions sessions = itemsList.get(position);
        viewholder.cal_sessionNameTV.setText(sessions.getSessionName());
        viewholder.cal_programNameTV.setText(sessions.getProgramName());
        viewholder.cal_batchTV.setText(sessions.getBatchName());
        viewholder.cal_timeTV.setText(sessions.getSessionTime());
//        viewholder.cal_sessionCountTV.setText(sessions.getSessionNumPlayers());
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}