package queuemanager;
/**
 *
 * @author Muhammad Usman
 */

public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    private ListNode<T> top;
    
    public UnsortedLinkedPriorityQueue() {
        top = null;
    }
    
    /**
     * This checks if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * This method returns the item with the highest priority
     */
    @Override
    public T head() {
        int h = highestPriority();
        ListNode<T> node = top;
        if (isEmpty()) {
            throw new StackUnderflowException();
        }else{
            for(int i=0; i<h;i++){
                node = node.getNext();
            }
        }
        return node.getItem();
    }
    
    /**
     * This method removes the item with the highest priority
     */
    @Override
    public void remove() throws QueueUnderflowException{
        int h = highestPriority();
        if (isEmpty()) {
            throw new StackUnderflowException();
        }else{
            ListNode<T> temp = top;
                System.out.println(h);
		int count=1;
                if(h==0){
                   top=top.next;
                }
                if(h==1){
                   top.next = top.next.next;
                }
                 if(h>1){
                     temp=top;
                    while(count<h){
                        count++;
                        temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        }
    }

    /**
     * This method adds a new item to the list
     * 
     * @param item
     * @param priority
     */
    @Override
    public void add(T item, int priority) {
        top = new ListNode<>(item, priority, top);
    }
    
    /**
     * This method outputs every node in the list
     * @return 
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
     * This method gets the size of the list and returns it
     */
    private int size() {
        ListNode<T> node = top;
        int size = 0;
        while (node != null) {
            size = size + 1;
            node = node.getNext();
        }
        return size;
    }
    
    /**
     * This method gets the node with the highest priority
     */
    public int highestPriority(){
        ListNode<T> node = top;
        int i = 0;
        int pos = 0;
        int priority = 0;
        int s = size();
        while (i < s) {
            if(node.getPriority()>=priority){
                pos=i;
                priority = node.getPriority();
            }
            node = node.getNext();
            i++;
        }
        return pos;
    }
}

