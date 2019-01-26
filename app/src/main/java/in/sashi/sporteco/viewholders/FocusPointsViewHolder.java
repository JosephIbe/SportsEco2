package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class FocusPointsViewHolder extends RecyclerView.ViewHolder {

    public TextView focusTV;

    public FocusPointsViewHolder(@NonNull View itemView) {
        super(itemView);

        focusTV = itemView.findViewById(R.id.focusTV);

    }
}
