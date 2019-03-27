package queuemanager;
/**
 *
 * @author Muhammad Usman
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
    public int tailIndex;

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

    /**
     * This method returns the item with the highest priority
     */
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
    
    /**
     * This method add a new item to the array
     * 
     * @param item
     * @param priority
     */
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

    /**
     * This method removes the item with the highest priority
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int h = highestPriority();
            for (int i = h ; i < (storage.length - 1) ; i++ ){
               storage[ i ] = storage[ i + 1 ] ; 
            }
            tailIndex = tailIndex - 1;
        }
    }

    /**
     * This method checks if the array is empty
     */
    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }
    
    /**
     * This method outputs all the items in the array
     */
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
    
    /**
     * This method figures out the item with the highest priority and returns it
     */
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
}
