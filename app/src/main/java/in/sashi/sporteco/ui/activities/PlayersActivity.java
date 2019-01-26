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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.sashi.sporteco.R;
import in.sashi.sporteco.adapters.PlayersAdapter;
import in.sashi.sporteco.models.players.Players;
import in.sashi.sporteco.utils.AppUtils;

import static in.sashi.sporteco.utils.Constants.BASE_URL;

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

//        populate();
        fetchPlayers(AppUtils.getCoachId());

    }

    private void fetchPlayers(String coachId) {

        JSONObject object = new JSONObject();
        try {
            object.put("coach_id", coachId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(BASE_URL + "player_list")
                .addJSONObjectBody(object)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONArray array = jsonObject.getJSONArray("player_details");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject details = array.getJSONObject(i);
                                Players players = new Players();
                                players.setUserId(details.getString("player_id"));
                                players.setFirstName(details.getString("first_name"));
                                players.setLastName(details.getString("last_name"));
                                players.setUsername(details.getString("username"));
                                players.setAddress(details.getString("address"));
                                players.setImageURL(details.getString("image"));
                                players.setStatePlayer(details.getString("state"));

                                players.save();
                                playersList.add(players);
                                adapter = new PlayersAdapter(PlayersActivity.this, playersList);
                                playersRV.setAdapter(adapter);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

}
