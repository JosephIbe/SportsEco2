package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.sashi.sporteco.R;
import in.sashi.sporteco.utils.Constants;
import in.sashi.sporteco.utils.RoundedCornersSheet;

public class OnGoingDrillDetailsFragment extends RoundedCornersSheet {

    private static final String TAG = OnGoingDrillDetailsFragment.class.getSimpleName();

    private String title_drill, total_time;
    private TextView ongoingDrillTitleTV, drillTimeLeftTV, drillDurationTV;

    private long START_TIME;
    private long totalTimeCountMs;
    private CountDownTimer downTimer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        total_time = getArguments().getString(Constants.DRILL_DURATION_KEY);
        title_drill = getArguments().getString(Constants.DRILL_TITLE_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_going_drill_details, container, false);
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        init(view);
        return view;
    }

    private void init(View view) {
        ongoingDrillTitleTV = view.findViewById(R.id.ongoingDrillTitleTV);
        drillTimeLeftTV = view.findViewById(R.id.drillTimeLeftTV);
        drillDurationTV = view.findViewById(R.id.drillDurationTV);

        set();

    }

    private void set() {
        ongoingDrillTitleTV.setText(title_drill);
        drillDurationTV.setText(total_time);
//        drillTimeLeftTV.setText(total_time);

        setTimer();

    }

    private void setTimer() {
        long duration = 0;
        if (total_time.contains(":") && total_time.length() > 3){
            String minutes = total_time.substring(0, 2);
            Log.d(TAG, "minutes:\t" + minutes);
            String seconds = total_time.substring(3, 5);
            Log.d(TAG, "seconds:\t" + seconds);
            int min = Integer.parseInt(minutes);
            Log.d(TAG, "minutes int:\t" + min);
            int sec = Integer.parseInt(seconds);
            Log.d(TAG, "seconds int:\t" + sec);
            String aggregateSec = String.valueOf((min * 60) + sec);
            duration = Long.parseLong(aggregateSec);
            Log.d(TAG, "converted seconds:\t" + aggregateSec + " and long duration:\t" + duration);
        }
//        START_TIME = 120;
        START_TIME = duration;
        totalTimeCountMs = START_TIME * 1000;

        startTimer();

    }

    private void startTimer() {
        downTimer = new CountDownTimer(totalTimeCountMs, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secs = millisUntilFinished / 1000;
                drillTimeLeftTV.setText(
                        String.format("%02d", secs/60 ) + " : " + String.format("%02d", secs % 60)
                );
            }

            @Override
            public void onFinish() {
//                drillTimeLeftTV.setText("00:00");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismiss();
                    }
                }, 1000);
            }
        }.start();
    }

}
