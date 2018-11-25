package in.sashi.sporteco.models.app;

public class Drills {

    public int iconImg;
    public String title;
    public String duration;
    public String coverImg;
    public String desc;
    public String focusPts;
    public boolean isFavorite;
    public boolean isPlaying;
    public String drillFocusPts;

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
