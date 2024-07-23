public class LinkedList {

    Node head = null;

    void displayList()
    {
        Node currNode = head;
        while(currNode != null)
        {

            currNode = currNode.next;
        }
        System.out.println("Debugging: Finished displayList!");
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
                    Node newHead = new Node(inputTask, currNode);
                    head = newHead;
                    break;
                }
                else if(currNode.next == null)
                {
                    currNode.next = new Node(inputTask, null);
                    break;
                }
                else if(inputTask.getTaskPriority() >= currNode.next.getNodePriority())
                {
                    Node tempNextNext = currNode.next.next;
                    currNode.next = new Node(inputTask, currNode.next);
                    System.out.println("greater than or equal to!");
                    break;
                }

                currNode = currNode.next;
                System.out.println("Testing: " + inputTask.getTaskPriority() + "Task priority");
            }
        }
        else
        {
            head = new Node(inputTask, null);
        }
        System.out.println("Testing: add Task complete");
    }


    //FIX BOTH REMOVE TASKS
    int removeTask(String inputValue)
    {
        int tasksDeleted = 0;
        Node currNode = head;
        if(isInteger(inputValue) && head != null)
        {
            while(currNode != null)
            {
                System.out.println("Test: Node value " + currNode.getNodePriority());
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

    boolean isInteger(String inputValue)
    {
        try
        {
            Integer.parseInt(inputValue);
        }
        catch(NumberFormatException error)
        {
            return false;
        }

        return true;
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
        Task nodeTask;
        Node next = null;
    }
}
