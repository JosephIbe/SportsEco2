package in.sashi.sporteco.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.models.app.Players;

public class EvaluateActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = EvaluateActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ImageView filterIV;
    private RecyclerView evalRV;

    private List<Players> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        init();

        filterIV.setOnClickListener(this);

        setUpItems();

    }

    private void setUpItems() {

        Players players = new Players();
        players.setFirstName("John");
        players.setLastName("Doe");
        players.setImageURL("");

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        filterIV = findViewById(R.id.filterIV);
        evalRV = findViewById(R.id.evalRV);

        setSupportActionBar(toolbar);

        evalRV.setHasFixedSize(true);
        LinearLayoutManager vlm = new LinearLayoutManager(this);
        vlm.setOrientation(LinearLayoutManager.VERTICAL);
        evalRV.setLayoutManager(vlm);
        evalRV.addItemDecoration(new DividerItemDecoration(this, vlm.getOrientation()));

    }

    @Override
    public void onClick(View v) {

    }
}
