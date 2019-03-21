/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author usman
 */



public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    private ListNode<T> top;
    
    public UnsortedLinkedPriorityQueue() {
        top = null;
    }
    
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
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

    
    @Override
    public void add(T item, int priority) {
        top = new ListNode<>(item, priority, top);
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

