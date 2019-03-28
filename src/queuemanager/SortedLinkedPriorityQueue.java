package queuemanager;
/**
 *
 * @author Muhammad Usman
 */

public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    private ListNode<T> top;
    
    public SortedLinkedPriorityQueue() {
        top = null;
    }
    
    /**
     * This method checks if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * This method returns the item at the top of the list
     */
    @Override
    public T head() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        //gets the item stored at the front and returns it
        return top.getItem();
    }
    
    /**
     * This method adds a new node to the list also sorts them from highest priority to lowest
     * 
     * @param item
     * @param priority
     */
    @Override
    public void add(T item, int priority){
        //initalises some variables
        ListNode temp = new ListNode<>(item, priority, top);
        ListNode start = top;
        //if its empty it adds a new node
        if(top==null){
            top = temp;
        //if the top node has a lower priority than the new one it will swap them    
        }else if (top.getPriority()<priority){
            temp.next = top;
            top = temp;
        }else{
        //goes through the nodes and look for the position to add it in    
            while(start.next != null && start.next.getPriority() > priority){
                start = start.next;
            }     
            temp.next = start.next;
            start.next = temp;
        }
    }
    
    /**
     * This method removes the node at the top of the list
     */
    @Override
    public void remove() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        //removes the item at the top
        top = top.getNext();
    }
    
    /**
     * This method outputs the nodes in the list
     */
    @Override
    public String toString() {
        String result = "Sorted Linked List:";
        result += " contents = [";
        for (ListNode<T> node = top; node != null; node = node.getNext()) {
            if (node != top) {
                result += ", ";
            }
            result += node.getItem();
            result += " ";
            result += node.getPriority();
        }
        result += "]";
        return result;
    }
    
    /**
     * This method returns the size of the list
     */
    public int size() {
        ListNode<T> node = top;
        int size = 0;
        //loops through the nodes and adds one to the size variable until there are no nodes left
        while (node != null) {
            size = size + 1;
            node = node.getNext();
        }
        //returns the size of the list
        return size;
    }    
}
