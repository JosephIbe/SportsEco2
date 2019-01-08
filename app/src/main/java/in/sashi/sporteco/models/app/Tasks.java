package in.sashi.sporteco.models.app;

public class Tasks {

    public String taskId;
    public String taskTitle;
    public String taskDesc;
    public String isComplete;

    public Tasks() { }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String isComplete() {
        return isComplete;
    }

    public void setComplete(String complete) {
        isComplete = complete;
    }
}
