package in.sashi.sporteco.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import in.sashi.sporteco.R;
import in.sashi.sporteco.utils.EmptyRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatsFragment extends Fragment {

    private static final String TAG = ChatsFragment.class.getSimpleName();

    private EmptyRecyclerView chatsRV;
    private RelativeLayout emptyState;
    private FloatingActionButton msgFAB;

    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        init(view);
        chatsRV.setEmptyView(emptyState);

        setUpRV();

        return view;
    }

    private void setUpRV() {
        chatsRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setStackFromEnd(true);
        llm.setReverseLayout(true);
        chatsRV.setLayoutManager(llm);
    }

    private void init(View view) {
        chatsRV = view.findViewById(R.id.chatsRV);
        emptyState = view.findViewById(R.id.emptyState);
        msgFAB = view.findViewById(R.id.msgFAB);
    }

}
