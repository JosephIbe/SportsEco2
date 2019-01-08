package in.sashi.sporteco.models.drills;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.sashi.sporteco.rest.db.SportsDatabase;

@Table(name = "session_drills", database = SportsDatabase.class)
public class Drills extends BaseModel {

    @Column
    public int iconImg;

    @Column
    public String title;

    @Column
    public String duration;

    @Column
    public String coverImg;

    @Column
    public String desc;

    @Column
    public String focusPts;

    @Column
    @PrimaryKey
    public String progId;

    @Column
    @PrimaryKey
    public String progSessId;

    @Column
    public String progSessionStepsId;

    @Column
    public String drillSessionMapping;

    @Column
    public String drillFocusPts;

    @Column
    public boolean isFavorite;

    public boolean isPlaying;

    public Drills() {
    }

    public Drills(int iconImg, String title, String duration, String coverImg, String desc, String focusPts, boolean isFavorite, boolean isPlaying, String drillFocusPts) {
        this.iconImg = iconImg;
        this.title = title;
        this.duration = duration;
        this.coverImg = coverImg;
        this.desc = desc;
        this.focusPts = focusPts;
        this.isFavorite = isFavorite;
        this.isPlaying = isPlaying;
        this.drillFocusPts = drillFocusPts;
    }

    public int getIconImg() {
        return iconImg;
    }

    public void setIconImg(int iconImg) {
        this.iconImg = iconImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFocusPts() {
        return focusPts;
    }

    public void setFocusPts(String focusPts) {
        this.focusPts = focusPts;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public String getDrillFocusPts() {
        return drillFocusPts;
    }

    public void setDrillFocusPts(String drillFocusPts) {
        this.drillFocusPts = drillFocusPts;
    }
}
