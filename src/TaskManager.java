import java.util.Scanner;
import java.util.InputMismatchException;


/*
TO DO:
DONE:
    case 5:
    in LinkedList -> create a findTask method to do removeSubTasks
    ErrorChecking integer and bool
    Edit Tasks (6)
    Error Checking reorganize list(reorganize list in case order is messed up from editing a task)
    NOT DONE:


CURRENTLY DOING:

*/
public class TaskManager {

    public static int tasksCompleted = 0;
    private LinkedList taskHolder = new LinkedList();
    ErrorChecking ErrorChecker = new ErrorChecking();


    public void mainView()
    {
        int viewInput = -1;

        taskHolder.displayList();

        while(true)
        {

            switch(viewInput) {
                case 0:
                    return;
                case 1:
                    menu();
                    break;
                default:
                    System.out.println("Type 0 to exit or Type 1 to go back to menu");
            }
            viewInput = Integer.parseInt(ErrorChecker.handleInteger());
        }

    }
    public void menu() throws InputMismatchException
    {
        Scanner userInput = new Scanner(System.in);
        int menuInput = -1;

        try
        {
            while (menuInput != 0) {
                System.out.println("TASKS COMPLETED: " + tasksCompleted);
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
                    case 0:
                        System.out.println("Exited task manager");
                        return;
                    case 1: //add task DONE
                        System.out.println("Enter the task name");
                        String taskName = userInput.nextLine().trim();

                        System.out.println("Enter a priority value");
                        int taskPriority = Integer.parseInt(ErrorChecker.handleInteger());

                        System.out.println("Enter a description or no description");
                        String taskDescription = userInput.nextLine().trim();

                        System.out.println("Does this have subtasks? (true or false)");
                        boolean boolValue = Boolean.parseBoolean(ErrorChecker.handleBool());

                        Task newTask = new Task(taskName, taskPriority, taskDescription, boolValue);

                        taskHolder.addTask(newTask);
                        mainView();
                        break;


                    case 2: //delete task DONE
                        System.out.println("Enter the name of a task or prefix of multiple tasks to delete them");
                        System.out.println("Alternatively, you can delete all tasks with a certain priority");
                        String deleteInput = userInput.nextLine();

                        System.out.println(taskHolder.removeTask(deleteInput) + " tasks deleted");
                        break;


                    case 3: //display task DONE
                        mainView();
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
        }
    }
    public static void main(String[] args)
    {
        TaskManager myTasks = new TaskManager();
        myTasks.menu();
    }
}

