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

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Programs;
import in.sashi.sporteco.ui.fragments.dialogs.ProgramSessionsFragment;
import in.sashi.sporteco.utils.Constants;
import in.sashi.sporteco.viewholders.ProgramsViewHolder;

import static in.sashi.sporteco.utils.Constants.PROGRAM_DESC_KEY;
import static in.sashi.sporteco.utils.Constants.PROGRAM_NAME_KEY;
import static in.sashi.sporteco.utils.Constants.PROGRAM_PLACE_NAME_KEY;

public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsViewHolder> {

    private final Context context;
    private List<Programs> itemsList;

    public ProgramsAdapter(Context context, List<Programs> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ProgramsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.programs_items_layout, parent, false);
        return new ProgramsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramsViewHolder viewholder, final int position) {
        final Programs programs = itemsList.get(position);
        viewholder.programTV.setText(programs.getProgramName());
        viewholder.sessionProgramsTV.setText(programs.getNumSessions());
        viewholder.dateProgramsTV.setText(programs.getStartDate());
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked:\t" + position, Toast.LENGTH_SHORT).show();
                ProgramSessionsFragment fragment = new ProgramSessionsFragment();
                Bundle bundle = new Bundle();
                bundle.putString(PROGRAM_NAME_KEY, programs.getProgramName());
                bundle.putString(PROGRAM_DESC_KEY, programs.getProgramDesc());
                bundle.putString(PROGRAM_PLACE_NAME_KEY, programs.getPlaceName());
                fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                fragment.setArguments(bundle);
                fragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "ProgramSessionsFragment");
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