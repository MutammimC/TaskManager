import java.io.InputStream;
import java.util.Scanner;
import java.util.InputMismatchException;
public class TaskManager {

    private LinkedList taskHolder = new LinkedList();

    public void menu() throws InputMismatchException
    {
        Scanner userInput = new Scanner(System.in);



        int scannerInput = -1;

        try
        {
            while (scannerInput != 0) {
                System.out.println("Welcome to the task manager, please choose the following actions");
                System.out.println("Add a task (1)");
                System.out.println("Remove a task (2)");
                System.out.println("Edit a task");
                System.out.println("View tasks");
                System.out.println("Complete a task");
                System.out.println("0 to quit");

                scannerInput = Integer.parseInt(userInput.nextLine());
                switch (scannerInput) {
                    case 1:
                        System.out.println("Enter the task name, priority, description or no description, and 1 or 0 if it has subtasks or not");
                        String taskName = userInput.nextLine().trim();
                        int taskPriority = Integer.parseInt(userInput.nextLine().trim());
                        String taskDescription = userInput.nextLine().trim();
                        boolean taskBool = Boolean.parseBoolean(userInput.nextLine().trim());
                        Task newTask = new Task(taskName, taskPriority, taskDescription, taskBool);
                        taskHolder.addTask(newTask);
                        taskHolder.displayList();
                        break;
                    case 2:
                        System.out.println("Enter the name of a task or prefix of multiple tasks to delete them");
                        System.out.println("Alternatively, you can delete all tasks with a certain priority");
                        String deleteInput = userInput.nextLine();

                            System.out.println(taskHolder.removeTask(deleteInput) + " tasks deleted");

                    case 4:
                        taskHolder.displayList();
                    default:
                        System.out.println("Please enter an integer from 0 to 5");
                }

            }
        } catch(InputMismatchException error)
        {
            System.out.println("INPUT ERROR");
            error.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        TaskManager myTasks = new TaskManager();
        myTasks.menu();
    }
}

