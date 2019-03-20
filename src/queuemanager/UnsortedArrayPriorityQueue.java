package queuemanager;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usman
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    /**
     * Where the data is actually stored.
     */
    private Object[] storage;

    /**
     * The size of the storage array.
     */
    private int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }



    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int h ;
            h = highestPriority();
            return ((PriorityItem<T>) storage[h]).getItem();
        }
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
            tailIndex = tailIndex + 1;
            if (tailIndex >= capacity) {
                Object[] tmp = storage;
                storage = (T[]) new Object[2 * capacity];
                for (int i = 0; i < tailIndex; i++) {
                    storage[i] = tmp[i];
                }
                capacity = storage.length;
            }
            storage[tailIndex] = item;
            storage[tailIndex] = new PriorityItem<>(item, priority);
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int h = highestPriority();
            //storage[i] = storage [i + 1];
            //tailIndex = tailIndex -1; 
            //https://www.cs.umd.edu/users/clin/MoreJava/Container/arr-remove.html
            for (int i = h ; i < (storage.length - 1) ; i++ ){
               storage[ i ] = storage[ i + 1 ] ; 
            }
            tailIndex = tailIndex - 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
    public int highestPriority(){
        int i = 0;
        int pos = 0;
        int priority = 0;
        
        while(i<tailIndex){
            if(((PriorityItem<T>) storage[i]).getPriority() >= priority){
                pos=i;
                priority = ((PriorityItem<T>) storage[i]).getPriority();
            }
            i++;
        }
        return pos;
    }
    
    /*
    public void test(){
        int h ;
        h = highestPriority();
        System.out.println(storage[h]);
    }
    */
}
