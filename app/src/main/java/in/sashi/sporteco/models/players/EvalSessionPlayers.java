package in.sashi.sporteco.models.players;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "eval_session_players", database = SportsDatabase.class,
        cachingEnabled = true, insertConflict = ConflictAction.IGNORE)
public class EvalSessionPlayers extends BaseModel {

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
    public String dobPlayer;

    @Column
    public String genderPlayer;

    @Column
    public String pinCodePlayer;

    @Column
    public String heightPlayer;

    @Column
    public String weightPlayer;

    @Column
    public String bsktballExpPlayer;

    @Column
    public String positionPlayer;

    @Column
    public String statePlayer;

    @Column
    public String mobilePlayer;

    @Column
    public String batchPlayer;

    @Column
    public String attendanceStatus;

    @Column
    public String sessionId;

    @Column
    public boolean isSelected;

    public EvalSessionPlayers() {
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public String getSessionId() {
        return sessionId;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
