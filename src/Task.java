import java.util.Scanner;

public class Task {
    private String taskName;
    private int taskPriority;
    private String description;
    protected boolean hasSubTasks = false;
    private LinkedList subTasks;
    private int subTaskCount = 0;


    Task(String inputTaskName, int inputPriority, String inputDesc, boolean inputBool)
    {
        this.taskName = inputTaskName;
        this.taskPriority = inputPriority;
        this.description = inputDesc;
        this.hasSubTasks = inputBool;

        if(hasSubTasks)
        {
            subTasks = new LinkedList();
            subTaskHandler();
        }
    }


    Task()
    {
        this.taskName = "null";
        this.taskPriority = -1;
        this.description = "Null";
        this.hasSubTasks = false;
    }


    private void subTaskHandler()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many subtasks does this task have?");
        subTaskCount = Integer.parseInt(userInput.nextLine().trim());
        if (subTaskCount == 0) {
            hasSubTasks = false;
            return;
        }
        for (int i = 0; i < subTaskCount; ++i) {
            System.out.println("Enter subtask name");
            String subTaskName = userInput.nextLine().trim();
            System.out.println("Enter subtask priority");
            int subPriority = Integer.parseInt(userInput.nextLine().trim());
            Task subTask = new Task(subTaskName, subPriority, "", false);
            subTasks.addTask(subTask);
        }
    }


    public void removeSubTask(String removeValue)
    {
        if(hasSubTasks)
        {
            subTasks.removeTask(removeValue);
            return;
        }
        else
        {
            System.out.println("This task has no subtasks");
            return;
        }
    }


    public void displayTask()
    {
        System.out.println(taskName + '\n' + "Priority: " + taskPriority + '\n' + "Description: " + description + '\n' + '\n');

        if(hasSubTasks)
        {
            System.out.println("SubTasks: ");
            subTasks.displayList();
        }
    }

    void editTask(String name, String Priority, String Description)
    {
        taskName = name;
        taskPriority = Integer.parseInt(Priority);
        this.description = Description;
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
