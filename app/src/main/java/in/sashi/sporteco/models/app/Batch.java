package in.sashi.sporteco.models.app;

public class Batch {

    private String message;

    public String batchId;

    public String batchName;

    public String programName;

    public String startDate;

    public String playersCount;

    public BatchFooter batchFooter;

    public Batch() {
    }

    public Batch(String batchId, String batchName, String programName, String startDate, String playersCount) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.programName = programName;
        this.startDate = startDate;
        this.playersCount = playersCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(String playersCount) {
        this.playersCount = playersCount;
    }

    public BatchFooter getBatchFooter() {
        return batchFooter;
    }

    public void setBatchFooter(BatchFooter batchFooter) {
        this.batchFooter = batchFooter;
    }
}
