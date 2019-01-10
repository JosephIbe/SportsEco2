package in.sashi.sporteco.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.sessions.HistorySessions;
import in.sashi.sporteco.ui.fragments.dialogs.AttendanceHistoryDetailsFragment;
import in.sashi.sporteco.viewholders.HistoryViewHolder;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {

    private final Context context;
    private List<HistorySessions> itemsList;

    public static final String KEY_SESSION_NAME = "session_name";
    public static final String KEY_PRESENT = "players_present";
    public static final String KEY_TOTAL = "total_players";

    public HistoryAdapter(Context context, List<HistorySessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_sessions_items_layout, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder viewholder, final int position) {
        final HistorySessions sessions = itemsList.get(position);

        viewholder.historyNameTV.setText(sessions.getSession_name());
//        viewholder.numSessionsHistoryTV.setText(sessions.getNumSessions_Drills());
        viewholder.historyBatchNameTV.setText(sessions.getBatch_name());
        viewholder.historyProgramNameTV.setText(sessions.getProgram_name());
        viewholder.history_present_countTV.setText(sessions.getPresent_count());
        viewholder.history_total_countTV.setText(sessions.getParticipants_count());
        viewholder.history_timeTV.setText(sessions.getHour_start());
        viewholder.history_dateTV.setText(sessions.getDate_start());

        Picasso.with(context)
                .load(sessions.getSession_cover_image())
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.historyIV);

        viewholder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked position " + position, Toast.LENGTH_SHORT).show();
                AttendanceHistoryDetailsFragment ahddf = new AttendanceHistoryDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString(KEY_SESSION_NAME, sessions.getSession_name());
                bundle.putString(KEY_PRESENT, sessions.getPresent_count());
                bundle.putString(KEY_TOTAL, sessions.getParticipants_count());
                ahddf.setArguments(bundle);
                ahddf.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
                ahddf.show(((AppCompatActivity)context).getSupportFragmentManager(), "AttendanceHistoryDetailsFragment");
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