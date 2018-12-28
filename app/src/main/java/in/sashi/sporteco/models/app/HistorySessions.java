package in.sashi.sporteco.models.app;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(database = SportsDatabase.class, name = "history_sessions",
        insertConflict = ConflictAction.REPLACE, updateConflict = ConflictAction.REPLACE,
        cachingEnabled = true)
public class HistorySessions extends BaseModel {

    @Column
    public String session_name;

    @PrimaryKey
    @Column
    public String session_id;

    @Column
    public String session_desc;

    @Column
    public String session_cover_image;

    @Column
    public String sess_duration;

    @Column
    public String program_id;

    @Column
    public String program_name;

    @Column
    public String batch_name;

    @Column
    public String session_focus_points;

    @Column
    public String equipments_reqd;

    @Column
    public String dateTime;

    @Column
    public String date_start;

    @Column
    public String date_end;

    @Column
    public String hour_start;

    @Column
    public String hour_end;

    @Column
    public String minute_start;

    @Column
    public String minute_end;

    @Column
    public String present_count;

    @Column
    public String participants_count;

    @ForeignKey
    public PlayerSession playerSession;

    @Column
    public String isComplete;

    public HistorySessions() {
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_desc() {
        return session_desc;
    }

    public void setSession_desc(String session_desc) {
        this.session_desc = session_desc;
    }

    public String getSession_cover_image() {
        return session_cover_image;
    }

    public void setSession_cover_image(String session_cover_image) {
        this.session_cover_image = session_cover_image;
    }

    public String getSess_duration() {
        return sess_duration;
    }

    public void setSess_duration(String sess_duration) {
        this.sess_duration = sess_duration;
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
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

    public String getSession_focus_points() {
        return session_focus_points;
    }

    public void setSession_focus_points(String session_focus_points) {
        this.session_focus_points = session_focus_points;
    }

    public String getEquipments_reqd() {
        return equipments_reqd;
    }

    public void setEquipments_reqd(String equipments_reqd) {
        this.equipments_reqd = equipments_reqd;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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

    public String getHour_start() {
        return hour_start;
    }

    public void setHour_start(String hour_start) {
        this.hour_start = hour_start;
    }

    public String getHour_end() {
        return hour_end;
    }

    public void setHour_end(String hour_end) {
        this.hour_end = hour_end;
    }

    public String getMinute_start() {
        return minute_start;
    }

    public void setMinute_start(String minute_start) {
        this.minute_start = minute_start;
    }

    public String getMinute_end() {
        return minute_end;
    }

    public void setMinute_end(String minute_end) {
        this.minute_end = minute_end;
    }

    public String getPresent_count() {
        return present_count;
    }

    public void setPresent_count(String present_count) {
        this.present_count = present_count;
    }

    public String getParticipants_count() {
        return participants_count;
    }

    public void setParticipants_count(String participants_count) {
        this.participants_count = participants_count;
    }

    public PlayerSession getPlayerSession() {
        return playerSession;
    }

    public void setPlayerSession(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }
}
