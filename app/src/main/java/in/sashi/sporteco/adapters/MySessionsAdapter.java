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
import in.sashi.sporteco.models.sessions.Sessions;
import in.sashi.sporteco.viewholders.MySessionsViewHolder;

public class MySessionsAdapter extends RecyclerView.Adapter<MySessionsViewHolder> {

    private static final String TAG = MySessionsAdapter.class.getSimpleName();

    private final Context context;
    private List<Sessions> itemsList;

    public MySessionsAdapter(Context context, List<Sessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public MySessionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_sessions_items_layout, parent, false);
        return new MySessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MySessionsViewHolder viewholder, int position) {
        final Sessions sessions = itemsList.get(position);
        viewholder.mySessionNameTV.setText(sessions.session_name);
        Picasso.with(context)
                .load(sessions.session_cover_image)
                .placeholder(R.drawable.app_logo_resized)
                .into(viewholder.mySessionIV);
        viewholder.checkBoxSelect.setChecked(false);
        viewholder.checkBoxSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d(TAG, "Session id:\t" + sessions.prog_sessionId);
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