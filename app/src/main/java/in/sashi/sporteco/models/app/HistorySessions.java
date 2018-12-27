package in.sashi.sporteco.models.app;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
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
    public String participants_count;

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

    public HistorySessions() {
    }


}
