package in.sashi.sporteco;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class TestDialog extends Fragment {

//    public TestDialog(@NonNull Context context) {
//        super(context);
//        this.context = context;
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        Window window = getWindow();
//        if (window != null){
//            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//
//        setContentView(R.layout.test_dialog_layout);
//
//    }


    public TestDialog() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
//        getActivity().getWindow().requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Window window = getActivity().getWindow();
        if (window != null){
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        View view = inflater.inflate(R.layout.test_dialog_layout, container, false);
        return  view;
    }
}
