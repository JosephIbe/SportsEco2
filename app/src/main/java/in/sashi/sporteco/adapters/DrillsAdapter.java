package in.sashi.sporteco.adapters;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Drills;
import in.sashi.sporteco.ui.fragments.DrillsDetailsFragment;
import in.sashi.sporteco.viewholders.DrillItemsViewHolder;

public class DrillsAdapter extends RecyclerView.Adapter<DrillItemsViewHolder> {

    private final Context context;
    private List<Drills> itemsList;

    public DrillsAdapter(Context context, List<Drills> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public DrillItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drill_items_layout, parent, false);
        return new DrillItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DrillItemsViewHolder viewholder, int position) {
        final Drills drills = itemsList.get(position);

        viewholder.drillsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrillsDetailsFragment fragment = new DrillsDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("drill_name", drills.getTitle());
                fragment.setArguments(bundle);
                fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar);
                fragment.setCancelable(true);
                fragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "DrillsDetailsFragment");
            }
        });

//        viewholder.drillIconIV.setImageResource(R.drawable.ic_drill_icon_bordered);

        viewholder.drillIconIV.setImageResource(drills.getIconImg());

        viewholder.favoriteDrillIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(((AppCompatActivity)context).findViewById(android.R.id.content), "Mock-Add to Favorites", Snackbar.LENGTH_LONG).show();
            }
        });

        viewholder.drillNameTV.setText(drills.getTitle());
        viewholder.durationTV.setText(drills.getDuration());
        viewholder.countDownTV.setText(drills.getDuration());

        viewholder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drills.setPlaying(true);
                if(drills.isPlaying){
                    viewholder.playBtn.setImageResource(R.drawable.ic_stop);
                    viewholder.timerLayout.setVisibility(View.VISIBLE);
                }
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