package in.sashi.sporteco.models.app;

import com.google.gson.annotations.SerializedName;

//@Table(name = "coach_profile")
//public class Coach extends Model {
public class Coach {

//    @Column(name = "id_coach")
    @SerializedName("coach_id")
    public String coachId;

//    @Column(name = "id_academy")
    @SerializedName("academy_id")
    public String academyId;

//    @Column(name = "username_coach")
    @SerializedName("username")
    public String username;

//    @Column(name = "first_name_coach")
    @SerializedName("first_name")
    public String firstName;

//    @Column(name = "last_name_coach")
    @SerializedName("last_name")
    public String lastName;

//    @Column(name = "gender_coach")
    @SerializedName("gender")
    public String gender;

//    @Column(name = "mobile_num_coach")
    @SerializedName("mobile")
    public String mobileNum;

//    @Column(name = "email_addr_coach")
    @SerializedName("email")
    public String emailAddr;

//    @Column(name = "middle_name_coach")
    @SerializedName("middle_name")
    public String midName;

//    @Column(name = "nick_name_coach")
    @SerializedName("nick_name")
    public String nickName;

//    @Column(name = "state_coach")
    @SerializedName("state")
    public String originState;

    public Coach() {
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

}