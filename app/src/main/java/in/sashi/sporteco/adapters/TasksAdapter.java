package in.sashi.sporteco.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Tasks;
import in.sashi.sporteco.viewholders.ToDoViewHolder;

public class TasksAdapter extends RecyclerView.Adapter<ToDoViewHolder> {

    private final Context context;
    private List<Tasks> itemsList;

    public TasksAdapter(Context context, List<Tasks> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_items_layout, parent, false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder viewholder, final int position) {
        final Tasks tasks = itemsList.get(position);
        viewholder.todoItemTV.setText(tasks.getTaskTitle());
        viewholder.checkTodo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    markComplete(tasks.getTaskId(), position); // remove from db with task id
                }
            }
        });
    }

    private void markComplete(String taskId, int position) {
        itemsList.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position, itemsList.size());
        Snackbar.make(((AppCompatActivity)context).findViewById(android.R.id.content), "Task Completed", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        }
        return itemsList.size();
    }
}