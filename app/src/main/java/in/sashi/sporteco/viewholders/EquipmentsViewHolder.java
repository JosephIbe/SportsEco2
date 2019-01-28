package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class EquipmentsViewHolder extends RecyclerView.ViewHolder {

    public TextView equipTV;

    public EquipmentsViewHolder(@NonNull View itemView) {
        super(itemView);

        equipTV = itemView.findViewById(R.id.equipTV);

    }
}
