package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Players;
import in.sashi.sporteco.viewholders.MarkAttendanceViewHolder;

public class MarkAttendanceAdapter extends RecyclerView.Adapter<MarkAttendanceViewHolder> {

    private static final String TAG = MarkAttendanceAdapter.class.getSimpleName();

    private final Context context;
    private List<Players> itemsList;

    public int numPresent = 0;

    public MarkAttendanceAdapter(Context context, List<Players> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public MarkAttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mark_attendance_items_layout, parent, false);
        return new MarkAttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MarkAttendanceViewHolder viewholder, final int position) {
        final Players players = itemsList.get(position);
        viewholder.namePlayerTV.setText(players.getFirstName() + " " + players.getLastName());
        Picasso.with(context)
                .load(players.getImageURL())
//                .resize(100, 100)
//                .centerCrop()
//                .transform(new CircleTransform(50, 0))
//                .fit()
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.playerAvatarIV);

        viewholder.playerAvatarIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewholder.checkBoxPlayer.setVisibility(View.VISIBLE);
                if (viewholder.checkBoxPlayer.isChecked()){
                    players.setSelected(true);
                    Log.d(TAG, "Checked");
                } else if (!viewholder.checkBoxPlayer.isChecked()){
                    players.setSelected(false);
                    Log.d(TAG, "Unchecked");
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

    public void checkAll() {

    }

    public void unCheckAll() {

    }

    public int sendNumChecked() {
        return numPresent;
    }

}