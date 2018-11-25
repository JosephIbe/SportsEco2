package in.sashi.sporteco.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Sessions;
import in.sashi.sporteco.ui.activities.ViewSessionActivity;
import in.sashi.sporteco.viewholders.SessionsViewHolder;

public class SessionsAdapter extends RecyclerView.Adapter<SessionsViewHolder> {

    private final Context context;
    private List<Sessions> itemsList;

    public SessionsAdapter(Context context, List<Sessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public SessionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_sessions_items_layout, parent, false);
        return new SessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SessionsViewHolder viewholder, int position) {
        final Sessions sessions =  itemsList.get(position);
        viewholder.sessionNameTV.setText(sessions.getSessionName());
        viewholder.programNameTV.setText(sessions.getProgramName());
        viewholder.batchNameTV.setText(sessions.getBatchName());
        viewholder.countTV.setText(sessions.getParticipantsCount());

        viewholder.sessCardHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewSessionActivity.class);
                intent.putExtra("session_name", sessions.getSessionName());
                context.startActivity(intent);
            }
        });

        Picasso.with(context)
                .load(sessions.getSessionIcon())
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.sessionIV);

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }

}