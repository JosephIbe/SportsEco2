package in.sashi.sporteco.models.app;

public class CalendarSessions {

    public String sessionName;
    public String sessionTime;
    public String programName;
    public String batchName;
    public String sessionNumPlayers;

    public CalendarSessions() {
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getSessionNumPlayers() {
        return sessionNumPlayers;
    }

    public void setSessionNumPlayers(String sessionNumPlayers) {
        this.sessionNumPlayers = sessionNumPlayers;
    }
}
