package in.sashi.sporteco.models.app;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(database = SportsDatabase.class, name = "coach_info",
        insertConflict = ConflictAction.REPLACE, updateConflict = ConflictAction.REPLACE,
        cachingEnabled = true)
public class CoachDetails extends BaseModel {

    @SerializedName("coach_id")
    @PrimaryKey
    @Column
    public String coachId;

    @SerializedName("academy_id")
    @Column
    public String academyId;

    @SerializedName("username")
    @Column
    public String username;

    @SerializedName("first_name")
    @Column
    public String firstName;

    @SerializedName("last_name")
    @Column
    public String lastName;

    @SerializedName("gender")
    @Column
    public String gender;

    @SerializedName("mobile")
    @Column
    public String mobileNum;

    @SerializedName("email")
    @Column
    public String emailAddr;

    @SerializedName("middle_name")
    @Column
    public String midName;

    @SerializedName("nick_name")
    @Column
    public String nickName;

    @SerializedName("state")
    @Column
    public String originState;

    @Column
    public String address;

    @Column
    public String imageURL;

    @Column
    public String batchCount;

    @Column
    public String playersCount;

    @Column
    public String programsCount;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        this.batchCount = batchCount;
    }

    public String getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(String playersCount) {
        this.playersCount = playersCount;
    }

    public String getProgramsCount() {
        return programsCount;
    }

    public void setProgramsCount(String programsCount) {
        this.programsCount = programsCount;
    }
}