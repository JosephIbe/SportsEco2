package in.sashi.sporteco.models.app;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "coach_batches")
public class Batch extends Model{

    private String message;

    @Column(name = "batch_id")
    public String batchId;

    @Column(name = "batch_name")
    public String batchName;

    @Column(name = "program_name")
    public String programName;

    @Column(name = "start_date")
    public String startDate;

    @Column(name = "playesr_count")
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
