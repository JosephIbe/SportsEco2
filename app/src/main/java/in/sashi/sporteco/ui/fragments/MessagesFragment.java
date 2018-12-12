package in.sashi.sporteco.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {

    private static final String TAG = MessagesFragment.class.getSimpleName();

    private Toolbar toolbar;
    private TabLayout msgTabs;
    private ViewPager viewPager;

    private ViewPagerAdapter pagerAdapter;

    public MessagesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        msgTabs = view.findViewById(R.id.msgTabs);
        viewPager = view.findViewById(R.id.viewPager);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Messages");

        setUpTabs();

        return view;
    }

    private void setUpTabs() {
        msgTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        msgTabs.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {

        ChatsFragment cf = new ChatsFragment();
        GroupsFragment gf = new GroupsFragment();

//        pagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        pagerAdapter.addFragTab(cf, "Chats");
        pagerAdapter.addFragTab(gf, "Groups");
        viewPager.setAdapter(pagerAdapter);
    }

}
