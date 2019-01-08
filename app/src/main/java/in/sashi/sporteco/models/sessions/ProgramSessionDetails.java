package in.sashi.sporteco.models.sessions;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "program_session_details", database = SportsDatabase.class, cachingEnabled = true,
        insertConflict = ConflictAction.IGNORE)
public class ProgramSessionDetails extends BaseModel {

    @PrimaryKey
    @Column
    public String progSessionId;

    @Column
    public String progId;

    @Column
    public String progSessionName;

    @Column
    public String progSessionNumDrills;

    @Column
    public String progImage;

    public ProgramSessionDetails() {
    }

    public String getProgSessionId() {
        return progSessionId;
    }

    public void setProgSessionId(String progSessionId) {
        this.progSessionId = progSessionId;
    }

    public String getProgId() {
        return progId;
    }

    public void setProgId(String progId) {
        this.progId = progId;
    }

    public String getProgSessionName() {
        return progSessionName;
    }

    public void setProgSessionName(String progSessionName) {
        this.progSessionName = progSessionName;
    }

    public String getProgSessionNumDrills() {
        return progSessionNumDrills;
    }

    public void setProgSessionNumDrills(String progSessionNumDrills) {
        this.progSessionNumDrills = progSessionNumDrills;
    }

    public String getProgImage() {
        return progImage;
    }

    public void setProgImage(String progImage) {
        this.progImage = progImage;
    }
}
