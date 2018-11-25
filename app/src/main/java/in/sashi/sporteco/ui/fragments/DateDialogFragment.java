package in.sashi.sporteco.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.sashi.sporteco.R;

public class DateDialogFragment extends BottomSheetDialogFragment {

    private static final String TAG = DateDialogFragment.class.getSimpleName();

    private TextView dateText;
    private String date;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        date = getArguments().getString("date_sel");
        if (date != null){
            Log.d(TAG, "Date passed:\t" + date);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.date_dialog_layout, container, false);

        dateText = v.findViewById(R.id.dateText);
        dateText.setText(date);

        return v;
    }
}
