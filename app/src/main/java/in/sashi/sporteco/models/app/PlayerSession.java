package in.sashi.sporteco.models.app;

//@Table(name = "players_list")
//public class PlayerSession extends Model {
public class PlayerSession {

//    @Column(name = "user_id_player")
    public String userId_player;

//    @Column(name = "first_name_player")
    public String firstName_player;

//    @Column(name = "last_name_player")
    public String lastName_player;

//    @Column(name = "image_url_player")
    public String imageURL;

//    @Column(name = "username_player")
    public String username;

//    @Column(name = "address_player")
    public String address_player;

//    @Column(name = "batch_name_player")
    public String batchName_player;

//    @Column(name = "batch_id_player")
    public String batchId_player;

//    @Column(name = "program_name_player")
    public String programName_player;

//    @Column(name = "program_id_player")
    public String programIdPlayer;

//    @Column(name = "program_start_date_player")
    public String startDate_player;

//    @Column(name = "program_end_date_player")
    public String endDate_player;

//    @Column(name = "program_user_map_id_player")
    public String programUserMapId_player;

//    @Column(name = "attendance_status")
    public String attendanceStatus_player;

//    @Column(name = "session_id_player")
    public String sessionId_player;

    public boolean isPresent;

    public PlayerSession() {
    }

    public PlayerSession(String userId_player, String firstName_player, String lastName_player, String imageURL, String username, String address_player, String batchName_player, String batchId_player, String programName_player, String programIdPlayer, String startDate_player, String endDate_player, String programUserMapId_player, String attendanceStatus_player, String sessionId_player, boolean isPresent) {
        this.userId_player = userId_player;
        this.firstName_player = firstName_player;
        this.lastName_player = lastName_player;
        this.imageURL = imageURL;
        this.username = username;
        this.address_player = address_player;
        this.batchName_player = batchName_player;
        this.batchId_player = batchId_player;
        this.programName_player = programName_player;
        this.programIdPlayer = programIdPlayer;
        this.startDate_player = startDate_player;
        this.endDate_player = endDate_player;
        this.programUserMapId_player = programUserMapId_player;
        this.attendanceStatus_player = attendanceStatus_player;
        this.sessionId_player = sessionId_player;
        this.isPresent = isPresent;
    }

    public String getUserId_player() {
        return userId_player;
    }

    public void setUserId_player(String userId_player) {
        this.userId_player = userId_player;
    }

    public String getFirstName_player() {
        return firstName_player;
    }

    public void setFirstName_player(String firstName_player) {
        this.firstName_player = firstName_player;
    }

    public String getLastName_player() {
        return lastName_player;
    }

    public void setLastName_player(String lastName_player) {
        this.lastName_player = lastName_player;
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

    public String getAddress_player() {
        return address_player;
    }

    public void setAddress_player(String address_player) {
        this.address_player = address_player;
    }

    public String getBatchName_player() {
        return batchName_player;
    }

    public void setBatchName_player(String batchName_player) {
        this.batchName_player = batchName_player;
    }

    public String getBatchId_player() {
        return batchId_player;
    }

    public void setBatchId_player(String batchId_player) {
        this.batchId_player = batchId_player;
    }

    public String getProgramName_player() {
        return programName_player;
    }

    public void setProgramName_player(String programName_player) {
        this.programName_player = programName_player;
    }

    public String getProgramIdPlayer() {
        return programIdPlayer;
    }

    public void setProgramIdPlayer(String programIdPlayer) {
        this.programIdPlayer = programIdPlayer;
    }

    public String getStartDate_player() {
        return startDate_player;
    }

    public void setStartDate_player(String startDate_player) {
        this.startDate_player = startDate_player;
    }

    public String getEndDate_player() {
        return endDate_player;
    }

    public void setEndDate_player(String endDate_player) {
        this.endDate_player = endDate_player;
    }

    public String getProgramUserMapId_player() {
        return programUserMapId_player;
    }

    public void setProgramUserMapId_player(String programUserMapId_player) {
        this.programUserMapId_player = programUserMapId_player;
    }

    public String getAttendanceStatus_player() {
        return attendanceStatus_player;
    }

    public void setAttendanceStatus_player(String attendanceStatus_player) {
        this.attendanceStatus_player = attendanceStatus_player;
    }

    public String getSessionId_player() {
        return sessionId_player;
    }

    public void setSessionId_player(String sessionId_player) {
        this.sessionId_player = sessionId_player;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
