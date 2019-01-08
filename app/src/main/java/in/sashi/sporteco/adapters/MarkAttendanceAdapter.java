package in.sashi.sporteco.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.models.sessions.PlayerSession;
import in.sashi.sporteco.viewholders.MarkAttendanceViewHolder;

public class MarkAttendanceAdapter extends RecyclerView.Adapter<MarkAttendanceViewHolder> {

    private static final String TAG = MarkAttendanceAdapter.class.getSimpleName();

    private final Context context;
    private List<PlayerSession> itemsList;

    private List<String> selectedList = new ArrayList<>();

    public int numPresent = 0;
    int count = 0;
    private MarkAttendanceViewHolder vh;

    public MarkAttendanceAdapter(Context context, List<PlayerSession> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public MarkAttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mark_attendance_items_layout, parent, false);
        vh = new MarkAttendanceViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MarkAttendanceViewHolder viewholder, int position) {
        final PlayerSession players = itemsList.get(position);
        viewholder.namePlayerTV.setText(players.getFirstName() + " " + players.getLastName());
        Picasso.with(context)
                .load(players.getImageURL())
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.playerAvatarIV);

        final boolean isClicked = players.isSelected();
        viewholder.playerAvatarIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                viewholder.checkBoxPlayer.setVisibility(isClicked ? View.VISIBLE : View.INVISIBLE);
//
//                players.setSelected(!players.isSelected());
//                players.setSelected(!isClicked);
//                Log.d(TAG, "Sel Status " + players.isSelected());

//                boolean isChecked = viewholder.checkBoxPlayer.isChecked();

                if (viewholder.checkBoxPlayer.isChecked()) {

//                    if (selectedList.contains(players.getFirstName())) {
//                        selectedList.remove(players.getFirstName());
//                        Log.d(TAG, "Removed:\t" + players.getFirstName());
//                    }

                    viewholder.checkBoxPlayer.setChecked(false);
                    viewholder.checkBoxPlayer.setVisibility(View.INVISIBLE);

                } else {
//                    if (!selectedList.contains(players.getFirstName())) {
//                        selectedList.add(players.getFirstName());
//                        Log.d(TAG, "Added:\t" + players.getFirstName());
//                    }
                    viewholder.checkBoxPlayer.setChecked(true);
                    viewholder.checkBoxPlayer.setVisibility(View.VISIBLE);
                }
            }
        });

        viewholder.checkBoxPlayer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "Checked:\t" + isChecked);
                if (isChecked) {
                    viewholder.checkBoxPlayer.setVisibility(View.VISIBLE);
                    players.setSelected(isChecked);
                    numPresent++;
                    Log.d(TAG, "Checkbox visible:\t and count:\t" + numPresent);
                } else {
                    viewholder.checkBoxPlayer.setVisibility(View.INVISIBLE);
                    players.setSelected(isChecked);
                    numPresent--;
                    Log.d(TAG, "Checkbox invisible:\t and count:\t" + numPresent);
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
        vh.checkBoxPlayer.setChecked(true);
    }

    public void unCheckAll() {
        vh.checkBoxPlayer.setChecked(false);
    }

    public int sendNumChecked() {
        return numPresent;
    }

}