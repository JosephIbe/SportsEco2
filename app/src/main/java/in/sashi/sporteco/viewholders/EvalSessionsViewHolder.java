package in.sashi.sporteco.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class EvalSessionsViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout eval_sess_rootLayout;
    public TextView eval_session_nameTV, eval_num_sessionsTV, eval_batch_nameTV,
            eval_program_nameTV, eval_present_countTV, eval_total_countTV, eval_timeTV, eval_dateTV;

    public EvalSessionsViewHolder(@NonNull View itemView) {
        super(itemView);

        eval_sess_rootLayout = itemView.findViewById(R.id.eval_sess_rootLayout);
        eval_session_nameTV = itemView.findViewById(R.id.eval_session_nameTV);
//        eval_num_sessionsTV = itemView.findViewById(R.id.eval_num_sessionsTV);
        eval_batch_nameTV = itemView.findViewById(R.id.eval_batch_nameTV);
        eval_program_nameTV = itemView.findViewById(R.id.eval_program_nameTV);
        eval_present_countTV = itemView.findViewById(R.id.eval_present_countTV);
        eval_total_countTV = itemView.findViewById(R.id.eval_total_countTV);
        eval_timeTV = itemView.findViewById(R.id.eval_timeTV);
        eval_dateTV = itemView.findViewById(R.id.eval_dateTV);

    }
}
