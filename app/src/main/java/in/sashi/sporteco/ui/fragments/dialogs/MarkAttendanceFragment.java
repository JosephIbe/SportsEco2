package in.sashi.sporteco.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.MarkAttendanceAdapter;
import in.sashi.sporteco.models.app.Players;

public class MarkAttendanceFragment extends DialogFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = MarkAttendanceFragment.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView closeIV;
    private TextView sessionNameAttendanceTV, totalTV, presentTV, absentTV;
    private Button doneBtn;

    private CheckBox checkAll;

    private RecyclerView attRV;
    private MarkAttendanceAdapter adapter;
    private List<Players> playersList = new ArrayList<>();

    private int amountChecked = 0, numPresent = 0, numAbsent = 0, sumPlayers = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mark_attendance, container, false);

        init(view);

        closeIV.setOnClickListener(this);
        checkAll.setOnCheckedChangeListener(this);
        doneBtn.setOnClickListener(this);

        return view;
    }

    private void init(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        closeIV = view.findViewById(R.id.closeIV);
        sessionNameAttendanceTV = view.findViewById(R.id.sessionNameAttendanceTV);
        checkAll = view.findViewById(R.id.checkAll);
        attRV = view.findViewById(R.id.attRV);
        totalTV = view.findViewById(R.id.totalTV);
        presentTV = view.findViewById(R.id.presentTV);
        absentTV = view.findViewById(R.id.absentTV);
        doneBtn = view.findViewById(R.id.doneBtn);

        setUpView();

        numPresent = adapter.sendNumChecked();
        Log.d(TAG, "Num Checked:\t" + numPresent);
        presentTV.setText(numPresent + "");

        sumPlayers = adapter.getItemCount();
        totalTV.setText(sumPlayers + "");

        numAbsent = sumPlayers - numPresent;
        absentTV.setText(numAbsent + "");

    }

    private void setUpView() {
        attRV.setHasFixedSize(true);
        attRV.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        populate();

    }

    private void populate() {
        Players one = new Players();
        one.setFirstName("Joseph");
        one.setLastName("Joey");
        one.setImageURL("https://bit.ly/2QoW661");
        playersList.add(one);

        Players two = new Players();
        two.setFirstName("Nikola");
        two.setLastName("Jokic");
        two.setImageURL("https://bit.ly/2DK1GJD");
        playersList.add(two);

        Players three = new Players();
        three.setFirstName("Michael");
        three.setLastName("Jordan");
        three.setImageURL("https://bit.ly/2DK1GJD");
        playersList.add(three);

        Players four = new Players();
        four.setFirstName("Cheryl");
        one.setLastName("Miller");
        four.setImageURL("https://bit.ly/2SaeAEs");
        playersList.add(four);

        Players five = new Players();
        five.setFirstName("Dwayne");
        five.setLastName("Wade");
        five.setImageURL("https://bit.ly/2DK1GJD");
        playersList.add(five);

        Players six = new Players();
        six.setFirstName("Maya");
        six.setLastName("Moore");
        six.setImageURL("https://bit.ly/2SaeAEs");
        playersList.add(six);

        Players seven = new Players();
        seven.setFirstName("Steph");
        seven.setLastName("Curry");
        seven.setImageURL("https://bit.ly/2DK1GJD");
        playersList.add(seven);

        Players eight = new Players();
        eight.setFirstName("Lisa");
        eight.setLastName("Leslie");
        eight.setImageURL("https://bit.ly/2SaeAEs");
        playersList.add(eight);

        Players nine = new Players();
        nine.setFirstName("Lebron");
        nine.setLastName("Blabla");
        nine.setImageURL("https://bit.ly/2DK1GJD");
        playersList.add(nine);

        Players ten = new Players();
        ten.setFirstName("Diana");
        ten.setLastName("Taurasi");
        ten.setImageURL("https://bit.ly/2SaeAEs");
        playersList.add(ten);

        adapter = new MarkAttendanceAdapter(getActivity(), playersList);
        attRV.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.closeIV:
                dismiss();
                break;
            case R.id.doneBtn:
                if (amountChecked <= 0) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "Please Mark Attendance", Snackbar.LENGTH_LONG).show();
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            adapter.checkAll();
        } else {
            adapter.unCheckAll();
        }
    }

}
