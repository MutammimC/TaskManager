import java.awt.*;
import java.io.InputStream;
import java.util.Scanner;
import java.util.InputMismatchException;


/*
TO DO:
DONE:
    case 5:
    in LinkedList -> create a findTask method to do removeSubTasks

    NOT DONE:
    Edit Tasks (6)
    Error Checking reorganize list(reorganize list in case order is messed up from editing a task)

CURRENTLY DOING:
    Error checking all integer inputs
*/
public class TaskManager {

    public static int tasksCompleted = 0;
    private LinkedList taskHolder = new LinkedList();
    ErrorChecking ErrorChecker = new ErrorChecking();

    public void menu() throws InputMismatchException
    {
        Scanner userInput = new Scanner(System.in);



        int menuInput = -1;

        try
        {
            while (menuInput != 0) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Welcome to the task manager, please choose the following actions");
                System.out.println("Add a task (1)");
                System.out.println("Remove a task (2)");
                System.out.println("View tasks (3)");
                System.out.println("Complete a task (4)");
                System.out.println("Complete a subtask (5)");
                System.out.println("Edit a task (6)");

                System.out.println("0 to quit");


                menuInput = Integer.parseInt(ErrorChecker.handleInteger());

                switch (menuInput) {
                    case 1: //add task DONE
                        System.out.println("Enter the task name");
                        String taskName = userInput.nextLine().trim();

                        System.out.println("Enter a priority value");
                        //int taskPriority = Integer.parseInt(userInput.nextLine().trim());

                        int taskPriority = Integer.parseInt(ErrorChecker.handleInteger());

                        System.out.println("Enter a description or no description");
                        String taskDescription = userInput.nextLine().trim();

                        System.out.println("Does this have subtasks? (true or false)");
                        boolean boolValue = Boolean.parseBoolean(ErrorChecker.handleBool());

                        Task newTask = new Task(taskName, taskPriority, taskDescription, boolValue);

                        taskHolder.addTask(newTask);
                        taskHolder.displayList();
                        break;


                    case 2: //delete task DONE
                        System.out.println("Enter the name of a task or prefix of multiple tasks to delete them");
                        System.out.println("Alternatively, you can delete all tasks with a certain priority");
                        String deleteInput = userInput.nextLine();

                        System.out.println(taskHolder.removeTask(deleteInput) + " tasks deleted");
                        break;


                    case 3: //display task DONE
                        taskHolder.displayList();
                        break;


                    case 4: //Complete a task DONE
                        System.out.println("Type the name of the task or prefix of tasks you've completed, priority values, or position in the list type example P3 for the third item");
                        tasksCompleted = taskHolder.removeTask(userInput.nextLine());
                        break;


                    case 5: //Complete subtasks DONE?
                        System.out.println("Type the name of the task or prefix of subtask's parent you've completed, priority values, or position in the list type example P3 for the third item");
                        String taskIdentifier =  userInput.nextLine();

                        taskHolder.removeSubTask(taskIdentifier);
                        break;


                    case 6:
                        System.out.println("Enter the name or position of the task");
                        taskHolder.editTask(userInput.nextLine());


                    default:
                        System.out.println("Please enter an integer from 0 to 6");
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

