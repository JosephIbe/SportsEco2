package in.sashi.sporteco.models.app;

public class Todo {

    public String itemTitle;
    public String itemDesc;
    public boolean isComplete;

    public Todo() { }

    public Todo(String itemTitle, String itemDesc, boolean isComplete) {
        this.itemTitle = itemTitle;
        this.itemDesc = itemDesc;
        this.isComplete = isComplete;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
