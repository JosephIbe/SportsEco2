package in.sashi.sporteco.models.app;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "sessions")
public class Sessions extends Model {

    @Column(name = "session_icon")
    public int sessionIcon;

    @Column(name = "session_name")
    public String sessionName;

    @Column(name = "batch_name")
    public String batchName;

    @Column(name = "participants_count")
    public String participantsCount;

    @Column(name = "date_time")
    public String dateTime;

    @Column(name = "session_focus_points")
    public String sessionFocusPoints;

    @Column(name = "equipments_reqd")
    public String equipmentsReqd;

    @Column(name = "date_start")
    public String date_start;

    @Column(name = "date_end")
    public String date_end;

    @Column(name = "hour_start")
    public String hour_start;

    @Column(name = "hour_end")
    public String hour_end;

    @Column(name = "minute_start")
    public String minute_start;

    @Column(name = "minute_end")
    public String minute_end;

    @Column(name = "coach_id")
    public String coachId;

    @Column(name = "program_session_id")
    public String programSessionId;

    @Column(name = "program_id")
    public String programId;

    @Column(name = "program_name")
    public String programName;

    @Column(name = "session_desc")
    public String sessionDesc;

    @Column(name = "session_image")
    public String sessionCoverImage;

    @Column(name = "session_duration")
    public String sessDuration;

    @Column(name = "present_count_players")
    public String presentCountPlayers;

    @Column(name = "session_status")
    public String status;

    public String numSessions_Drills;

//    @Column(name = "session_video_link")
//    public String sessionVideoLink;

    public Sessions() {
    }

    public Sessions(int sessionIcon, String sessionName, String batchName, String participantsCount) {
        this.sessionIcon = sessionIcon;
        this.sessionName = sessionName;
        this.batchName = batchName;
        this.participantsCount = participantsCount;
    }

    public Sessions(int sessionIcon, String sessionName, String batchName, String presentCountPlayers, String participantsCount, String dateTime, String sessionFocusPoints, String equipmentsReqd, String date_start, String date_end, String hour_start, String hour_end, String minute_start, String minute_end, String coachId, String programSessionId, String programId, String programName, String sessionDesc, String sessionCoverImage, String sessDuration, String status, String numSessions_Drills) {
        this.sessionIcon = sessionIcon;
        this.sessionName = sessionName;
        this.batchName = batchName;
        this.presentCountPlayers = presentCountPlayers;
        this.participantsCount = participantsCount;
        this.dateTime = dateTime;
        this.sessionFocusPoints = sessionFocusPoints;
        this.equipmentsReqd = equipmentsReqd;
        this.date_start = date_start;
        this.date_end = date_end;
        this.hour_start = hour_start;
        this.hour_end = hour_end;
        this.minute_start = minute_start;
        this.minute_end = minute_end;
        this.coachId = coachId;
        this.programSessionId = programSessionId;
        this.programId = programId;
        this.programName = programName;
        this.sessionDesc = sessionDesc;
        this.sessionCoverImage = sessionCoverImage;
        this.sessDuration = sessDuration;
        this.status = status;
        this.numSessions_Drills = numSessions_Drills;
    }

    public int getSessionIcon() {
        return sessionIcon;
    }

    public void setSessionIcon(int sessionIcon) {
        this.sessionIcon = sessionIcon;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getPresentCountPlayers() {
        return presentCountPlayers;
    }

    public void setPresentCountPlayers(String presentCountPlayers) {
        this.presentCountPlayers = presentCountPlayers;
    }

    public String getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(String participantsCount) {
        this.participantsCount = participantsCount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSessionFocusPoints() {
        return sessionFocusPoints;
    }

    public void setSessionFocusPoints(String sessionFocusPoints) {
        this.sessionFocusPoints = sessionFocusPoints;
    }

    public String getEquipmentsReqd() {
        return equipmentsReqd;
    }

    public void setEquipmentsReqd(String equipmentsReqd) {
        this.equipmentsReqd = equipmentsReqd;
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

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getProgramSessionId() {
        return programSessionId;
    }

    public void setProgramSessionId(String programSessionId) {
        this.programSessionId = programSessionId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getSessionDesc() {
        return sessionDesc;
    }

    public void setSessionDesc(String sessionDesc) {
        this.sessionDesc = sessionDesc;
    }

    public String getSessionCoverImage() {
        return sessionCoverImage;
    }

    public void setSessionCoverImage(String sessionCoverImage) {
        this.sessionCoverImage = sessionCoverImage;
    }

    public String getSessDuration() {
        return sessDuration;
    }

    public void setSessDuration(String sessDuration) {
        this.sessDuration = sessDuration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumSessions_Drills() {
        return numSessions_Drills;
    }

    public void setNumSessions_Drills(String numSessions_Drills) {
        this.numSessions_Drills = numSessions_Drills;
    }
}
