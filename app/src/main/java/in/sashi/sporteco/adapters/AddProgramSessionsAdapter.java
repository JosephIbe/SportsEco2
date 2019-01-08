package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.sessions.Sessions;
import in.sashi.sporteco.viewholders.AddProgramSessionViewHolder;

public class AddProgramSessionsAdapter extends RecyclerView.Adapter<AddProgramSessionViewHolder> {

    private final Context context;
    private List<Sessions> itemsList;

    public AddProgramSessionsAdapter(Context context, List<Sessions> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public AddProgramSessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_program_sessions_items_layout, parent, false);
        return new AddProgramSessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddProgramSessionViewHolder viewholder, int position) {
        Sessions sessions = itemsList.get(position);

        viewholder.add_program_sessionNameTV.setText(sessions.session_name);
        Picasso.with(context)
                .load(R.drawable.app_logo_resized)
                .into(viewholder.add_program_sessionIV);

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}