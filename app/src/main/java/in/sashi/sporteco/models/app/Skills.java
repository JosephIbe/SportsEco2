package in.sashi.sporteco.models.app;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "player_skills", database = SportsDatabase.class, cachingEnabled = true)
public class Skills extends BaseModel {

    @PrimaryKey
    @Column
    public String skillId;

    @Column
    public String name;

    @Column
    public String acadId;
//    public String desc;

    public Skills() {
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcadId() {
        return acadId;
    }

    public void setAcadId(String acadId) {
        this.acadId = acadId;
    }
}
