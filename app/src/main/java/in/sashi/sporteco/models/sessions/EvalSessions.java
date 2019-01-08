package in.sashi.sporteco.models.sessions;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.models.drills.EvalDrills;
import in.sashi.sporteco.models.players.EvalSessionPlayers;
import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "eval_sessions", database = SportsDatabase.class,
        insertConflict = ConflictAction.IGNORE, cachingEnabled = true)
public class EvalSessions extends BaseModel {

    @Column
    public String sessionIcon;

    @Column
    public String sessionName;

    @PrimaryKey
    @Column
    public String sessionId;

    @Column
    public String sessionDesc;

    @Column
    public String program_name;

    @Column
    public String batch_name;

    @Column
    public String totalCount;

    @Column
    public String sessionTime;

    @Column
    public String date;

    @Column
    public String date_start;

    @Column
    public String date_end;

    @Column
    public String presentCount;

    @ForeignKey
    public EvalDrills evalDrills;

    @ForeignKey
    public EvalSessionPlayers sessionPlayers;

    public EvalSessions() {
    }

    public String getSessionIcon() {
        return sessionIcon;
    }

    public void setSessionIcon(String sessionIcon) {
        this.sessionIcon = sessionIcon;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSession_id() {
        return sessionId;
    }

    public void setSession_id(String session_id) {
        this.sessionId = session_id;
    }

    public String getSessionDesc() {
        return sessionDesc;
    }

    public void setSessionDesc(String sessionDesc) {
        this.sessionDesc = sessionDesc;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getPresentCount() {
        return presentCount;
    }

    public void setPresentCount(String presentCount) {
        this.presentCount = presentCount;
    }
}
