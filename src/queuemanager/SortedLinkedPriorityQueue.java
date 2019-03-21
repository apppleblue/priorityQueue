/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author usman
 * @param <T>
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    private ListNode<T> top;
    
    public SortedLinkedPriorityQueue() {
        top = null;
    }
    
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public T head() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return top.getItem();
    }
    
    @Override
    public void add(T item, int priority){
        if(top == null){
            top = new ListNode<>(item, priority, top);
        }
        
        if(top != null){
            if(top.getPriority()<priority){
                top = new ListNode<>(item, priority, top);
            }
        }
    }
    
    @Override
    public void remove() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        top = top.getNext();
    }
    
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
    
    private int size() {
        ListNode<T> node = top;
        int size = 0;
        while (node != null) {
            size = size + 1;
            node = node.getNext();
        }
        return size;
    }
    
    
    
}
