package in.sashi.sporteco.models.app;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "program_details")
public class Programs extends Model {

    @Column(name = "program_name")
    public String programName;

    @Column(name = "program_id")
    public String progId;

    @Column(name = "prog_user_map_id")
    public String progUserMapId;

    @Column(name = "start_date")
    public String startDate;

    @Column(name = "end_date")
    public String endDate;

    @Column(name = "batch")
    public Batch batch;

    @Column(name = "coach_id")
    public String coachId;

    public String numSessions;

    public String programDesc;

    public String placeName;

    public Programs() {
    }

    public Programs(String programName, String progId, String progUserMapId, String startDate, String endDate, Batch batch, String coachId) {
        this.programName = programName;
        this.progId = progId;
        this.progUserMapId = progUserMapId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.batch = batch;
        this.coachId = coachId;
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

    public String getProgUserMapId() {
        return progUserMapId;
    }

    public void setProgUserMapId(String progUserMapId) {
        this.progUserMapId = progUserMapId;
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

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
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
}
