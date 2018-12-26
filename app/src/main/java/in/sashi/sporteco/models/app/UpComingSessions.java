package in.sashi.sporteco.models.app;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(database = SportsDatabase.class, name = "upcoming_sessions")
public class UpComingSessions  extends BaseModel {

    @Column
    public String sessionName;

    @PrimaryKey
    @Column
    public String session_id;

    @Column
    public String session_desc;

//    @Column
//    public String session_cover_image;

    @Column
    public String sessDuration;

    @Column
    public String program_name;

    @Column
    public String batchName;

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
    public String players_count;

    @Column
    public String isComplete;

    public UpComingSessions() {
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
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

    public String getSessDuration() {
        return sessDuration;
    }

    public void setSessDuration(String sessDuration) {
        this.sessDuration = sessDuration;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
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

    public String getPlayers_count() {
        return players_count;
    }

    public void setPlayers_count(String players_count) {
        this.players_count = players_count;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

}
