package in.sashi.sporteco.models.batch;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "eval_batch_players", database = SportsDatabase.class)
public class EvalBatchPlayers extends BaseModel {

    @PrimaryKey
    @Column
    public String userId;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @Column
    public String imageURL;

    @Column
    public String username;

    @Column
    public String address;

    @Column
    public String statePlayer;

    @Column
    public String batchId;

    public EvalBatchPlayers() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatePlayer() {
        return statePlayer;
    }

    public void setStatePlayer(String statePlayer) {
        this.statePlayer = statePlayer;
    }

    

}
