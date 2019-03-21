package queuemanager;

public class ListNode<T> {
    private final T item;
    //final ListNode<T> next;
    ListNode<T> next;
    private int priority;
    
    public ListNode(T item, int priority, ListNode<T> next ) {
        this.item = item;
        this.priority = priority;
        this.next = next;
    }
    
    public T getItem() {
        return item;
    }
    
    public ListNode<T> getNext() {
        return next;
    }
    
    public int getPriority() {
        return priority;
    }
}
