package in.sashi.sporteco.models.sessions;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(database = SportsDatabase.class, name = "players_session",
        insertConflict = ConflictAction.IGNORE, cachingEnabled = true)
public class PlayerSession extends BaseModel {

//    @PrimaryKey
    @Column(name = "player_id")
    public String userId;

    @PrimaryKey
    @Column(name = "prog_session_id")
    public String progSessId;

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
    public String attendanceStatus;

    public boolean isSelected;

    public PlayerSession() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProgSessId() {
        return progSessId;
    }

    public void setProgSessId(String progSessId) {
        this.progSessId = progSessId;
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

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
