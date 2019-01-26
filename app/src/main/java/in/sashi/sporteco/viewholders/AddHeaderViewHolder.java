package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import in.sashi.sporteco.R;

public class AddHeaderViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout addHeaderLayout;
    public CircleImageView add_headerIV;
    public TextView addHeaderText;

    public AddHeaderViewHolder(@NonNull View itemView) {
        super(itemView);

        add_headerIV = itemView.findViewById(R.id.add_headerIV);
        addHeaderText = itemView.findViewById(R.id.addHeaderText);
        addHeaderLayout = itemView.findViewById(R.id.addHeaderLayout);
    }
}
