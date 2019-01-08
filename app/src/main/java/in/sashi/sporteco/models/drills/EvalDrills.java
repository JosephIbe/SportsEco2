package in.sashi.sporteco.models.drills;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "eval_drills", database = SportsDatabase.class, primaryKeyConflict = ConflictAction.IGNORE)
public class EvalDrills extends BaseModel {

    @PrimaryKey
    @Column
    public String progSessId;

    @Column
    public String progSessStepsId;

    @Column
    public String progDrillName;

    @Column
    public String progDrillDesc;

    @Column
    public String progDrillFocusPts;

    @Column
    public String progDrillVideoURL;

    @Column
    public String progDrillImg;

    @Column
    public String progDrillDurn;

    @Column
    public String progDrillSessionMapping;

    public boolean isExpanded;

    public EvalDrills() {
    }

    public String getProgSessId() {
        return progSessId;
    }

    public void setProgSessId(String progSessId) {
        this.progSessId = progSessId;
    }

    public String getProgSessStepsId() {
        return progSessStepsId;
    }

    public void setProgSessStepsId(String progSessStepsId) {
        this.progSessStepsId = progSessStepsId;
    }

    public String getProgDrillName() {
        return progDrillName;
    }

    public void setProgDrillName(String progDrillName) {
        this.progDrillName = progDrillName;
    }

    public String getProgDrillDesc() {
        return progDrillDesc;
    }

    public void setProgDrillDesc(String progDrillDesc) {
        this.progDrillDesc = progDrillDesc;
    }

    public String getProgDrillFocusPts() {
        return progDrillFocusPts;
    }

    public void setProgDrillFocusPts(String progDrillFocusPts) {
        this.progDrillFocusPts = progDrillFocusPts;
    }

    public String getProgDrillVideoURL() {
        return progDrillVideoURL;
    }

    public void setProgDrillVideoURL(String progDrillVideoURL) {
        this.progDrillVideoURL = progDrillVideoURL;
    }

    public String getProgDrillImg() {
        return progDrillImg;
    }

    public void setProgDrillImg(String progDrillImg) {
        this.progDrillImg = progDrillImg;
    }

    public String getProgDrillDurn() {
        return progDrillDurn;
    }

    public void setProgDrillDurn(String progDrillDurn) {
        this.progDrillDurn = progDrillDurn;
    }

    public String getProgDrillSessionMapping() {
        return progDrillSessionMapping;
    }

    public void setProgDrillSessionMapping(String progDrillSessionMapping) {
        this.progDrillSessionMapping = progDrillSessionMapping;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
