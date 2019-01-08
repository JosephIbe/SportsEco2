package in.sashi.sporteco.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Skills;
import in.sashi.sporteco.viewholders.SkillsViewHolder;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsViewHolder> {

    private final Context context;
    private List<Skills> itemsList;

    public SkillsAdapter(Context context, List<Skills> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public SkillsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skills_items_layout, parent, false);
        return new SkillsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SkillsViewHolder viewholder, int position) {
        Skills skills = itemsList.get(position);

        viewholder.nameSkill.setText(skills.getName());

    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}