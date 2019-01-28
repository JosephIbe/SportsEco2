package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Equipments;
import in.sashi.sporteco.viewholders.EquipmentsViewHolder;

public class EquipmentsAdapter extends RecyclerView.Adapter<EquipmentsViewHolder> {

    private final Context context;
    private List<Equipments> itemsList;

    public EquipmentsAdapter(Context context, List<Equipments> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public EquipmentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.equip_items_layout, parent, false);
        return new EquipmentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EquipmentsViewHolder viewholder, int position) {
        Equipments equipments = itemsList.get(position);
        viewholder.equipTV.setText(equipments.getTitle());
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}