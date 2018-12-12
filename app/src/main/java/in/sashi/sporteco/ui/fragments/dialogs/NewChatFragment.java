package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.sashi.sporteco.R;

public class NewChatFragment extends DialogFragment {

    private static final String TAG = NewChatFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV, searchIV, filterIV;

    private RecyclerView newChatRV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_chat, container, false);
        init(view);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        searchIV = view.findViewById(R.id.searchIV);
        filterIV = view.findViewById(R.id.filterIV);
        newChatRV = view.findViewById(R.id.newChatRV);
    }
}
