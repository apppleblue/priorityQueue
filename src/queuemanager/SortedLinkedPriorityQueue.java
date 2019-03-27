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
        ListNode temp = new ListNode<>(item, priority, top);
        ListNode start = top;
        if(top==null){
            top = temp;
        }else if (top.getPriority()<priority){
            temp.next = top;
            top = temp;
        }else{
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
        top = top.getNext();
    }
    
    /**
     * This method outputs the nodes in the list
     */
    @Override
    public String toString() {
        String result = "LinkedStack: size = " + size();
        result += ", contents = [";
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
        while (node != null) {
            size = size + 1;
            node = node.getNext();
        }
        return size;
    }    
}
