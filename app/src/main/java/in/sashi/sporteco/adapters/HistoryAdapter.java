package in.sashi.sporteco.adapters;

import android.content.Context;
import android.content.Intent;
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
import in.sashi.sporteco.models.app.Sessions;
import in.sashi.sporteco.ui.fragments.dialogs.AttendanceHistoryDetailsDialogFragment;
import in.sashi.sporteco.viewholders.HistoryViewHolder;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {

    private final Context context;
    private List<Sessions> itemsList;

    public static final String KEY_SESSION_NAME = "session_name";
    public static final String KEY_PRESENT = "players_present";
    public static final String KEY_TOTAL = "total_players";

    public HistoryAdapter(Context context, List<Sessions> itemsList) {
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
        final Sessions sessions = itemsList.get(position);
//        viewholder.historyNameTV.setText(sessions.getSessionName());
//        viewholder.numSessionsHistoryTV.setText(sessions.getNumSessions_Drills());
//        viewholder.historyBatchNameTV.setText(sessions.getBatchName());
//        viewholder.historyProgramNameTV.setText(sessions.getProgramName());
//        viewholder.history_present_countTV.setText(sessions.getPresentCountPlayers());
//        viewholder.history_total_countTV.setText(sessions.getParticipantsCount());
//        viewholder.history_timeTV.setText(sessions.getHour_start());
//        viewholder.history_dateTV.setText(sessions.getDate_start());
//
//        Picasso.with(context)
//                .load(sessions.getSessionIcon())
//                .placeholder(R.drawable.app_logo_resized)
//                .into(viewholder.historyIV);
//
//        viewholder.rootLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Clicked position " + position, Toast.LENGTH_SHORT).show();
//                AttendanceHistoryDetailsDialogFragment ahddf = new AttendanceHistoryDetailsDialogFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString(KEY_SESSION_NAME, sessions.getSessionName());
//                bundle.putString(KEY_PRESENT, sessions.getPresentCountPlayers());
//                bundle.putString(KEY_TOTAL, sessions.getParticipantsCount());
//                ahddf.setArguments(bundle);
//                ahddf.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
//                ahddf.show(((AppCompatActivity)context).getSupportFragmentManager(), "AttendanceHistoryDetailsDialogFragment");
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