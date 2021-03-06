package in.sashi.sporteco.models.app;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "programs", database = SportsDatabase.class,
        cachingEnabled = true)
public class Programs extends BaseModel {

    @Column
    public String programName;

    @PrimaryKey
    @Column
    public String progId;

    @Column
    public String startDate;

    @Column
    public String endDate;

    @Column
    public String numSessions;

    @Column
    public String programDesc;

    @Column
    public String placeName;

    @Column
    public String progImg;

    @Column
    public String player_count;

    public Programs() {
    }

    public Programs(String programName, String progId, String startDate, String endDate, String numSessions, String progImage, String programDesc, String placeName) {
        this.programName = programName;
        this.progId = progId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numSessions = numSessions;
        this.progImg = progImage;
        this.programDesc = programDesc;
        this.placeName = placeName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgId() {
        return progId;
    }

    public void setProgId(String progId) {
        this.progId = progId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNumSessions() {
        return numSessions;
    }

    public void setNumSessions(String numSessions) {
        this.numSessions = numSessions;
    }

    public String getProgramDesc() {
        return programDesc;
    }

    public void setProgramDesc(String programDesc) {
        this.programDesc = programDesc;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getProgImg() {
        return progImg;
    }

    public void setProgImg(String progImg) {
        this.progImg = progImg;
    }

    public String getPlayer_count() {
        return player_count;
    }

    public void setPlayer_count(String player_count) {
        this.player_count = player_count;
    }
}
