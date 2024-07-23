public class Task {

    private String taskName;
    private int taskPriority;
    private String description;
    private boolean hasSubTasks = false;
    Task[] subTasks;


    Task(String inputTaskName, int inputPriority, String inputDesc, boolean inputBool)
    {
        this.taskName = inputTaskName;
        this.taskPriority = inputPriority;
        this.description = inputDesc;
        this.hasSubTasks = inputBool;
    }

    public void DisplayTask()
    {
        System.out.println(taskName + '\n' + "Priority: " + taskPriority + '\n' + "Description: " + description + '\n' + '\n');
    }



    public int getTaskPriority() {
        return taskPriority;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
