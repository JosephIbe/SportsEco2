package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.MarkAttendanceAdapter;
import in.sashi.sporteco.adapters.PlayersAdapter;
import in.sashi.sporteco.models.app.Players;

public class PlayersActivity extends AppCompatActivity {

    private static final String TAG = PlayersActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private RecyclerView playersRV;
    private FloatingActionButton addPlayerFAB;

    private List<Players> playersList = new ArrayList<>();
    private PlayersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        init();
        setSupportActionBar(toolbar);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        backIV = findViewById(R.id.backIV);
        playersRV = findViewById(R.id.playersRV);
        addPlayerFAB = findViewById(R.id.addPlayerFAB);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayersActivity.this, MainActivity.class));
                finish();
            }
        });

        addPlayerFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(android.R.id.content), "Action Coming Soon", Snackbar.LENGTH_LONG).show();
            }
        });

        playersRV.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(this, 3);
        playersRV.setLayoutManager(glm);

        adapter = new PlayersAdapter(this, playersList);

        populate();

    }

    private void populate() {
        Players one = new Players();
        one.setFirstName("Joseph");
        one.setLastName("Joey");
        one.setImageURL("https://bit.ly/2QoW661");
        one.setBatchPlayer("Batch One");
        playersList.add(one);

        Players two = new Players();
        two.setFirstName("Nikola");
        two.setLastName("Jokic");
        two.setImageURL("https://bit.ly/2DK1GJD");
        two.setBatchPlayer("Batch One");
        playersList.add(two);

        Players three = new Players();
        three.setFirstName("Michael");
        three.setLastName("Jordan");
        three.setImageURL("https://bit.ly/2DK1GJD");
        three.setBatchPlayer("Batch One");
        playersList.add(three);

        Players four = new Players();
        four.setFirstName("Cheryl");
        one.setLastName("Miller");
        four.setImageURL("https://bit.ly/2SaeAEs");
        four.setBatchPlayer("Batch One");
        playersList.add(four);

        Players five = new Players();
        five.setFirstName("Dwayne");
        five.setLastName("Wade");
        five.setImageURL("https://bit.ly/2DK1GJD");
        five.setBatchPlayer("Batch One");
        playersList.add(five);

        Players six = new Players();
        six.setFirstName("Maya");
        six.setLastName("Moore");
        six.setImageURL("https://bit.ly/2SaeAEs");
        six.setBatchPlayer("Batch One");
        playersList.add(six);

        Players seven = new Players();
        seven.setFirstName("Steph");
        seven.setLastName("Curry");
        seven.setImageURL("https://bit.ly/2DK1GJD");
        seven.setBatchPlayer("Batch One");
        playersList.add(seven);

        Players eight = new Players();
        eight.setFirstName("Lisa");
        eight.setLastName("Leslie");
        eight.setImageURL("https://bit.ly/2SaeAEs");
        eight.setBatchPlayer("Batch One");
        playersList.add(eight);

        Players nine = new Players();
        nine.setFirstName("Lebron");
        nine.setLastName("Blabla");
        nine.setImageURL("https://bit.ly/2DK1GJD");
        nine.setBatchPlayer("Batch One");
        playersList.add(nine);

        Players ten = new Players();
        ten.setFirstName("Diana");
        ten.setLastName("Taurasi");
        ten.setImageURL("https://bit.ly/2SaeAEs");
        ten.setBatchPlayer("Batch One");
        playersList.add(ten);

        adapter = new PlayersAdapter(this, playersList);
        playersRV.setAdapter(adapter);

    }

}
