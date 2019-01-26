package in.sashi.sporteco.models.app;

public class AdapterHeaderItem {

    public int headerIcon;
    public String headerTitle;

    public AdapterHeaderItem() { }

    public AdapterHeaderItem(int headerIcon, String headerTitle) {
        this.headerIcon = headerIcon;
        this.headerTitle = headerTitle;
    }

    public int getHeaderIcon() {
        return headerIcon;
    }

    public void setHeaderIcon(int headerIcon) {
        this.headerIcon = headerIcon;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

}
