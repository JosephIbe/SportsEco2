package in.sashi.sporteco.models.app;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(database = SportsDatabase.class)
public class CoachDetails extends BaseModel {

    @SerializedName("coach_id")
    @PrimaryKey
    @Column
    public String coachId;

    @SerializedName("academy_id")
    public String academyId;

    @SerializedName("username")
    public String username;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("gender")
    public String gender;

    @SerializedName("mobile")
    public String mobileNum;

    @SerializedName("email")
    public String emailAddr;

    @SerializedName("middle_name")
    public String midName;

    @SerializedName("nick_name")
    public String nickName;

    @SerializedName("state")
    public String originState;

    public CoachDetails() {
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(String originState) {
        this.originState = originState;
    }

    public void insertInfo(String coach_id, String acadId, String username, String first, String last, String gender, String mobile, String mid_name, String nick, String state) {
        this.coachId = coach_id;
        this.academyId = acadId;
        this.username = username;
        this.firstName = first;
        this.lastName = last;
        this.gender = gender;
        this.mobileNum = mobile;
        this.midName = mid_name;
        this.nickName = nick;
        this.originState = state;
    }
}