package in.sashi.sporteco;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.view.Window;

public class TestDialog extends BottomSheetDialog {

    private Context context;

    public TestDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        Window window = getWindow();
        if (window != null){
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        setContentView(R.layout.test_dialog_layout);

    }
}
