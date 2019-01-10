package in.sashi.sporteco.adapters;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.sessions.ProgramSessionDetails;
import in.sashi.sporteco.ui.fragments.dialogs.ViewSessionDialogFragment;
import in.sashi.sporteco.utils.Constants;
import in.sashi.sporteco.viewholders.ProgramsSessionsViewHolder;

public class ProgramsSessionsAdapter extends RecyclerView.Adapter<ProgramsSessionsViewHolder> {

    private final Context context;
    private List<ProgramSessionDetails> itemsList;

    public ProgramsSessionsAdapter(Context context, List<ProgramSessionDetails> itemsList) {
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
        final ProgramSessionDetails sessions = itemsList.get(position); // TODO: 12/16/2018 Bind Drills to Sessions and Sessions to Programs from Server

        viewholder.program_sessionNameTV.setText(sessions.getProgSessionName());
        viewholder.program_drillsTV.setText(sessions.getProgSessionNumDrills());

        Picasso.with(context)
                .load(sessions.getProgImage())
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.program_sessionIV);

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewSessionDialogFragment fragment = new ViewSessionDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.PROGRAM_SESSION_ID_KEY, sessions.getProgSessionId());
                fragment.setArguments(bundle);
                fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar);
                fragment.setCancelable(true);
                fragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "DrillsDetailsFragment");
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