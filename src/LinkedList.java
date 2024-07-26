import java.util.Scanner;

public class LinkedList {

    ErrorChecking ErrorChecker = new ErrorChecking();
    Node head = null;


    void displayList()
    {
        int taskCount = 0;
        Node currNode = head;
        while(currNode != null)
        {
            System.out.println(++taskCount + ":");


            System.out.println();

            currNode.nodeTask.displayTask();

            System.out.println();


            currNode = currNode.next;
        }
    }


    void addTask(Task inputTask)
    {
        if(head != null)
        {
            Node currNode = head;

            while(currNode != null)
            {
                if(inputTask.getTaskPriority() > currNode.getNodePriority())
                {
                    head = new Node(inputTask, currNode);
                    break;
                }
                else if(currNode.next == null)
                {
                    currNode.next = new Node(inputTask, null);
                    break;
                }
                else if(inputTask.getTaskPriority() >= currNode.next.getNodePriority())
                {
                    currNode.next = new Node(inputTask, currNode.next);
                    break;
                }

                currNode = currNode.next;

            }
        }
        else
        {
            head = new Node(inputTask, null);
        }

    }


    int removeTask(String inputValue)
    {
        int tasksDeleted = 0;
        Node currNode = head;

        if(inputValue.matches("P\\d+"))
        {
            String slicedValue  = inputValue.substring(1);
            final int TASK_POSITION = Integer.parseInt(slicedValue) - 1;
            int listIndex = 0;
            while(currNode != null)
            {
                if(listIndex == TASK_POSITION && listIndex == 0)
                {
                    head = head.next;
                    ++tasksDeleted;
                    return tasksDeleted = 1;
                }
                else if(listIndex == TASK_POSITION - 1)
                {
                    currNode.next = currNode.next.next;
                    return tasksDeleted = 1;
                }
                ++listIndex;
                currNode = currNode.next;
            }
            return tasksDeleted;
        }
        else if(ErrorChecker.isInteger(inputValue) && head != null)
        {
            while(currNode != null)
            {
                if(currNode.getNodePriority() == Integer.parseInt(inputValue))
                {
                    head = currNode.next;
                    ++tasksDeleted;
                }
                else if(currNode.next == null)
                {
                    break;
                }
                else if(currNode.next.getNodePriority() == Integer.parseInt(inputValue))
                {
                    currNode.next = currNode.next.next;
                    ++tasksDeleted;
                }
                currNode = currNode.next;
            }
        }
        else if(head != null)
        {
            while(currNode != null)
            {
                if(currNode.nodeTask.getTaskName().startsWith(inputValue))
                {
                    head = currNode.next;
                    ++tasksDeleted;
                }
                else if(currNode.next == null)
                {
                    break;
                }
                else if(currNode.next.nodeTask.getTaskName().startsWith(inputValue))
                {
                    currNode.next = currNode.next.next;
                    ++tasksDeleted;
                }
                currNode = currNode.next;
            }
        }
     return tasksDeleted;
    }

    private Task findTask(String inputValue)
    {
        Node currNode = head;

        if(inputValue.matches("P\\d+"))
        {
            String slicedValue  = inputValue.substring(1);
            final int TASK_POSITION = Integer.parseInt(slicedValue) - 1;
            int listIndex = 0;
            while(currNode != null)
            {
                if(listIndex == TASK_POSITION && listIndex == 0)
                {
                    return head.nodeTask;
                }
                else if(listIndex == TASK_POSITION - 1)
                {
                    return currNode.next.nodeTask;
                }
                ++listIndex;
                currNode = currNode.next;
            }
            return null;
        }
        else if(ErrorChecker.isInteger(inputValue) && head != null)
        {
            while(currNode != null)
            {
                System.out.println("Test: Node value " + currNode.getNodePriority());
                if(currNode.getNodePriority() == Integer.parseInt(inputValue))
                {
                    return currNode.nodeTask;
                }
                else if(currNode.next == null)
                {
                    break;
                }
                else if(currNode.next.getNodePriority() == Integer.parseInt(inputValue))
                {
                    return currNode.next.nodeTask;
                }
                currNode = currNode.next;
            }
        }
        else if(head != null)
        {
            while(currNode != null)
            {
                if(currNode.nodeTask.getTaskName().startsWith(inputValue))
                {
                    return head.nodeTask;
                }
                else if(currNode.next == null)
                {
                    break;
                }
                else if(currNode.next.nodeTask.getTaskName().startsWith(inputValue))
                {
                    return currNode.next.nodeTask;
                }
                currNode = currNode.next;
            }
        }
        return null;
    }

    void editTask(String inputValue)
    {
        Task taskToEdit = findTask(inputValue);

        if(taskToEdit != null)
        {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter the new task name");
            String newTaskName = userInput.nextLine();
            String newTaskPriority = ErrorChecker.handleInteger();
            String newTaskDescription = userInput.nextLine();

            taskToEdit.editTask(newTaskName,newTaskPriority,newTaskDescription);
            UpdateList(findTask(newTaskName));
        }
    }
    void removeSubTask(String taskIdentifier)
    {
        Task removeTask = findTask(taskIdentifier);

        if(removeTask != null && removeTask.hasSubTasks)
        {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter Subtask name, priority, or P# of subtask");
            String inputRemove = userInput.nextLine();
            removeTask.removeSubTask(inputRemove);

        }
        else
        {
            System.out.println("This task doesn't exist or has no subtasks");
        }
    }

    private void UpdateList(Task inputTask)
    {
        if(inputTask != null)
        {
            Task tempInputTask = inputTask;
            removeTask(inputTask.getTaskName());
            addTask(tempInputTask);
            return;
        }
    }
    private static class Node
    {
        Node(Task insertTask, Node nextNode)
        {

            nodeTask = insertTask;
            next = nextNode;
        }

        public int getNodePriority()
        {
            return nodeTask.getTaskPriority();
        }
        protected Task nodeTask;
        protected Node next = null;
    }
}
