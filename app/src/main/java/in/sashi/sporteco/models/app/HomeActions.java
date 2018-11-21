package in.sashi.sporteco.models.app;

public class HomeActions {

    public int img;
    public String actionName;

    public HomeActions() {
    }

    public HomeActions(int img, String actionName) {
        this.img = img;
        this.actionName = actionName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
