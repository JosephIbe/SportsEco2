package in.sashi.sporteco.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Todo;
import in.sashi.sporteco.viewholders.ToDoViewHolder;

public class TodoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {

    private final Context context;
    private List<Todo> itemsList;

    public TodoAdapter(Context context, List<Todo> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_items_layout, parent, false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder viewholder, int position) {
        Todo itemTodo = itemsList.get(position);
        viewholder.todoItemTV.setText(itemTodo.getItemTitle());
        viewholder.checkTodo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

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