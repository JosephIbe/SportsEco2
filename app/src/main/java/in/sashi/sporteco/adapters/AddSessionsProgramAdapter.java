package in.sashi.sporteco.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.AdapterHeaderItem;
import in.sashi.sporteco.models.sessions.Sessions;
import in.sashi.sporteco.ui.fragments.dialogs.home_actions_dialogs.programs.ProgramsSessionsListFragment;
import in.sashi.sporteco.viewholders.AddHeaderViewHolder;
import in.sashi.sporteco.viewholders.AddProgramSessionViewHolder;

public class AddSessionsProgramAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Object> list;

    public static final int HEADER_VIEW = 0;
    public static final int ITEMS_VIEW = 1;

    public AddSessionsProgramAdapter(Context context, List<Object> objectList){
        this.context = context;
        this.list = objectList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = null;
        switch (viewType){
            case HEADER_VIEW:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_session_header_layout, viewGroup, false);
                return new AddHeaderViewHolder(view);
            case ITEMS_VIEW:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_program_sessions_items_layout, viewGroup, false);
                return new AddProgramSessionViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof AddHeaderViewHolder){
            AdapterHeaderItem headerItem = (AdapterHeaderItem) list.get(position);
            AddHeaderViewHolder holder = (AddHeaderViewHolder) viewHolder;

            holder.addHeaderText.setText(headerItem.getHeaderTitle());
            Picasso.with(context)
                    .load(R.drawable.app_logo_resized)
                    .into(holder.add_headerIV);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Header Clicked", Toast.LENGTH_SHORT).show();
                    ProgramsSessionsListFragment listFragment = new ProgramsSessionsListFragment();
                    listFragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                    listFragment.show(((AppCompatActivity)context).getSupportFragmentManager(), "ProgramsSessionsListFragment");
                }
            });

        } else if (viewHolder instanceof AddProgramSessionViewHolder){
            AddProgramSessionViewHolder holder = (AddProgramSessionViewHolder) viewHolder;
            Sessions sessions = (Sessions) list.get(position);

            holder.add_program_sessionNameTV.setText(sessions.session_name);
            Picasso.with(context)
                    .load(R.drawable.app_logo_resized)
                    .into(holder.add_program_sessionIV);
        }
    }

    @Override
    public int getItemCount() {
        if (list.size() == 0){
            return 0;
        }
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderPosition(position)){
            return HEADER_VIEW;
        }
        return ITEMS_VIEW;
    }

    private boolean isHeaderPosition(int position) {
        return position == 0;
    }
}
