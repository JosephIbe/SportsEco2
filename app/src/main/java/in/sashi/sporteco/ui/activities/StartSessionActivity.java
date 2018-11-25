package in.sashi.sporteco.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.DrillsAdapter;
import in.sashi.sporteco.models.app.Drills;

public class StartSessionActivity extends AppCompatActivity {

    private static final String TAG = StartSessionActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView backIV;
    private TextView nameSessStartTV;

    private String session_name;

    private RecyclerView startSessRV;
    private List<Drills> itemsList = new ArrayList<>();
    private DrillsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_session);

        session_name = getIntent().getExtras().getString("session_name");

        init();
        setSupportActionBar(toolbar);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartSessionActivity.this, MainActivity.class));
                finish();
            }
        });

        nameSessStartTV.setText(session_name);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        backIV = findViewById(R.id.backIV);
        nameSessStartTV = findViewById(R.id.nameSessStartTV);
        startSessRV = findViewById(R.id.startSessRV);

        setUpRV();

    }

    private void setUpRV() {
        startSessRV.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        startSessRV.setLayoutManager(llm);
        startSessRV.addItemDecoration(new DividerItemDecoration(this, llm.getOrientation()));

        mockDrills();

    }

    private void mockDrills() {
        Drills one = new Drills();
        one.setPlaying(false);
        one.setFavorite(false);
        one.setTitle("Carolina Shooting1");
        one.setDuration("20:01");
        one.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(one);

        Drills two = new Drills();
        two.setPlaying(false);
        two.setFavorite(false);
        two.setTitle("Carolina Shooting2");
        two.setDuration("20:02");
        two.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(two);

        Drills three = new Drills();
        three.setPlaying(false);
        three.setFavorite(false);
        three.setTitle("Carolina Shooting3");
        three.setDuration("20:03");
        three.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(three);

        Drills four = new Drills();
        four.setPlaying(false);
        four.setFavorite(false);
        four.setTitle("Carolina Shooting4");
        four.setDuration("20:04");
        four.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(four);

        Drills five = new Drills();
        five.setPlaying(false);
        five.setFavorite(false);
        five.setTitle("Carolina Shooting5");
        five.setDuration("20:05");
        five.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(five);

        Drills six = new Drills();
        six.setPlaying(false);
        six.setFavorite(false);
        six.setTitle("Carolina Shooting6");
        six.setDuration("20:06");
        six.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(six);

        Drills seven = new Drills();
        seven.setPlaying(false);
        seven.setFavorite(false);
        seven.setTitle("Carolina Shooting7");
        seven.setDuration("20:07");
        seven.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(seven);

        Drills eight = new Drills();
        eight.setPlaying(false);
        eight.setFavorite(false);
        eight.setTitle("Carolina Shooting8");
        eight.setDuration("20:08");
        eight.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(eight);

        Drills nine = new Drills();
        nine.setPlaying(false);
        nine.setFavorite(false);
        nine.setTitle("Carolina Shooting8");
        nine.setDuration("20:08");
        nine.setIconImg(R.drawable.ic_drill_icon_bordered);
        itemsList.add(nine);

        adapter = new DrillsAdapter(this, itemsList);
        startSessRV.setAdapter(adapter);

    }

}
