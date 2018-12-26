package in.sashi.sporteco.models.app;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(database = SportsDatabase.class, name = "players")
public class Players extends BaseModel {

//    @SerializedName("")
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
    public boolean isSelected;

    public Players() {
    }

    public Players(String userId, String firstName, String lastName, String imageURL, String username, String address, String dobPlayer, String genderPlayer, String pinCodePlayer, String heightPlayer, String weightPlayer, String bsktballExpPlayer, String positionPlayer, String statePlayer, String mobilePlayer, String batchPlayer, boolean isSelected) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageURL = imageURL;
        this.username = username;
        this.address = address;
        this.dobPlayer = dobPlayer;
        this.genderPlayer = genderPlayer;
        this.pinCodePlayer = pinCodePlayer;
        this.heightPlayer = heightPlayer;
        this.weightPlayer = weightPlayer;
        this.bsktballExpPlayer = bsktballExpPlayer;
        this.positionPlayer = positionPlayer;
        this.statePlayer = statePlayer;
        this.mobilePlayer = mobilePlayer;
        this.batchPlayer = batchPlayer;
        this.isSelected = isSelected;
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

    public String getDobPlayer() {
        return dobPlayer;
    }

    public void setDobPlayer(String dobPlayer) {
        this.dobPlayer = dobPlayer;
    }

    public String getGenderPlayer() {
        return genderPlayer;
    }

    public void setGenderPlayer(String genderPlayer) {
        this.genderPlayer = genderPlayer;
    }

    public String getPinCodePlayer() {
        return pinCodePlayer;
    }

    public void setPinCodePlayer(String pinCodePlayer) {
        this.pinCodePlayer = pinCodePlayer;
    }

    public String getHeightPlayer() {
        return heightPlayer;
    }

    public void setHeightPlayer(String heightPlayer) {
        this.heightPlayer = heightPlayer;
    }

    public String getWeightPlayer() {
        return weightPlayer;
    }

    public void setWeightPlayer(String weightPlayer) {
        this.weightPlayer = weightPlayer;
    }

    public String getBsktballExpPlayer() {
        return bsktballExpPlayer;
    }

    public void setBsktballExpPlayer(String bsktballExpPlayer) {
        this.bsktballExpPlayer = bsktballExpPlayer;
    }

    public String getPositionPlayer() {
        return positionPlayer;
    }

    public void setPositionPlayer(String positionPlayer) {
        this.positionPlayer = positionPlayer;
    }

    public String getStatePlayer() {
        return statePlayer;
    }

    public void setStatePlayer(String statePlayer) {
        this.statePlayer = statePlayer;
    }

    public String getMobilePlayer() {
        return mobilePlayer;
    }

    public void setMobilePlayer(String mobilePlayer) {
        this.mobilePlayer = mobilePlayer;
    }

    public String getBatchPlayer() {
        return batchPlayer;
    }

    public void setBatchPlayer(String batchPlayer) {
        this.batchPlayer = batchPlayer;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
