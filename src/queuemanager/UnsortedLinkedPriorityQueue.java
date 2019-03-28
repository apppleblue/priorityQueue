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
        //returns if the list is empty
        return top == null;
    }
    
    /**
     * This method returns the item with the highest priority
     */
    @Override
    public T head() {
        //runs the highestPriority function adn stores the result in h
        int h = highestPriority();
        ListNode<T> node = top;
        if (isEmpty()) {
            throw new StackUnderflowException();
        }else{
            //loops through until it goes to the node with the highest priority
            for(int i=0; i<h;i++){
                node = node.getNext();
            }
        }
        //returns the node with the highest priority
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
		int count=1;
                //if theres only one item it removes that
                if(h==0){
                   top=top.next;
                }
                //if there is two it removes the top one and moves the other one up
                if(h==1){
                   top.next = top.next.next;
                }
                 if(h>1){
                    temp=top;
                    //remoes the top one then moves all the items up one 
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
        //adds a new item to the top of the list
        top = new ListNode<>(item, priority, top);
    }
    
    /**
     * This method outputs every node in the list
     * @return 
     */
    @Override
    public String toString() {
        String result = "LinkedStack: ";
        result += "contents = [";
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
        //goes thorough the nodes and counts the number of nodes
        while (node != null) {
            size = size + 1;
            node = node.getNext();
        }
        //returns the number of nodes
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
        //goes through the array and gets the item with the highest priority
        while (i < s) {
            if(node.getPriority()>=priority){
                pos=i;
                priority = node.getPriority();
            }
            node = node.getNext();
            i++;
        }
        //returns the position of the node with the highest priority
        return pos;
    }
}

