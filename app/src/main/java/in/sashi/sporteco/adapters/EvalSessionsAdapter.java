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

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Sessions;
import in.sashi.sporteco.ui.fragments.evaluate.EvaluateSessionDetailFragment;
import in.sashi.sporteco.viewholders.EvalSessionsViewHolder;

public class EvalSessionsAdapter extends RecyclerView.Adapter<EvalSessionsViewHolder> {

    private final Context context;
    private List<Sessions> itemsList;

    public EvalSessionsAdapter(Context context, List<Sessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public EvalSessionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eval_session_items_layout, parent, false);
        return new EvalSessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EvalSessionsViewHolder holder, int position) {
        final Sessions sessions = itemsList.get(position);
//        holder.eval_session_nameTV.setText(sessions.getSessionName());
//        holder.eval_batch_nameTV.setText(sessions.getBatchName());
//        holder.eval_program_nameTV.setText(sessions.getProgramName());
//        holder.eval_num_sessionsTV.setText(); what here?
//        holder.eval_present_countTV.setText(sessions.getPresentCountPlayers());
//        holder.eval_dateTV.setText(sessions.getDateTime());
//        holder.eval_total_countTV.setText(sessions.getParticipantsCount());
//        holder.eval_timeTV.setText(sessions.getHour_start()); // TODO: 12/8/2018 Use proper time formatting
//
//        holder.eval_sess_rootLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EvaluateSessionDetailFragment fragment = new EvaluateSessionDetailFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString("name_session", sessions.getSessionName());
//                fragment.setArguments(bundle);
//                fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar);
//                fragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "EvaluateSessionDetailFragment");
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