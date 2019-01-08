package in.sashi.sporteco.models.batch;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "eval_batch", database = SportsDatabase.class)
public class EvalBatch extends BaseModel {

    @PrimaryKey
    @Column
    public String batchId;

    @Column
    public String batchName;

    @Column
    public String programName;

    @Column
    public String playersCount;

    @ForeignKey
    public EvalBatchPlayers batchPlayers;

    public EvalBatch() {
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(String playersCount) {
        this.playersCount = playersCount;
    }

    public EvalBatchPlayers getBatchPlayers() {
        return batchPlayers;
    }

    public void setBatchPlayers(EvalBatchPlayers batchPlayers) {
        this.batchPlayers = batchPlayers;
    }
}
