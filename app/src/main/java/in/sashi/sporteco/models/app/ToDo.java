package in.sashi.sporteco.models.app;

public class ToDo {

    public String itemTitle;
    public boolean isComplete;

    public ToDo() { }

    public ToDo(String itemTitle, boolean isComplete) {
        this.itemTitle = itemTitle;
        this.isComplete = isComplete;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
