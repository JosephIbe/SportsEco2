package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Programs;
import in.sashi.sporteco.models.app.Sessions;
import in.sashi.sporteco.viewholders.ProgramsSessionsViewHolder;

public class ProgramsSessionsAdapter extends RecyclerView.Adapter<ProgramsSessionsViewHolder> {

    private final Context context;
    private List<Sessions> itemsList;

    public ProgramsSessionsAdapter(Context ctx) {
        this.context = ctx;
    }

    public ProgramsSessionsAdapter(Context context, List<Sessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ProgramsSessionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.programs_sessions_items_list, parent, false);
        return new ProgramsSessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramsSessionsViewHolder viewholder, int position) {
        Sessions sessions = itemsList.get(position); // TODO: 12/16/2018 Bind Drills to Sessions and Sessions to Programs from Server

//        viewholder.program_sessionNameTV.setText("Session 1");
//        viewholder.program_drillsTV.setText("23");

        viewholder.program_drillsTV.setText(sessions.getNumSessions_Drills());
        viewholder.program_sessionNameTV.setText(sessions.getSessionName());

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}