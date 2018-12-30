package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class ToDoViewHolder extends RecyclerView.ViewHolder {

    public TextView todoItemTV;
    public CheckBox checkTodo;

    public ToDoViewHolder(@NonNull View itemView) {
        super(itemView);

        todoItemTV = itemView.findViewById(R.id.todoItemTV);
        checkTodo = itemView.findViewById(R.id.checkTodo);

    }
}
