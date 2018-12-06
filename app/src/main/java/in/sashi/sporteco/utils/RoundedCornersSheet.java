package in.sashi.sporteco.utils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;

import in.sashi.sporteco.R;

public class RoundedCornersSheet extends BottomSheetDialogFragment {

    public int theme = R.style.BottomSheetDialogTheme;

    @Override
    public int getTheme() {
        return theme;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new BottomSheetDialog(requireContext(), theme);
    }
}
