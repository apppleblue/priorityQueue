package queuemanager;
/**
 *
 * @author Muhammad Usman
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T>{
        //Initalises the required varaibles.
        private Object[] storage;
        private int capacity;
        public int tailIndex;
    
    public HeapPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        tailIndex = 0;
    }
    
    /**
     * This method checks what item is in the head
     * if there is nothing it will throw the QueueUnderFlowException error
     * if there is something it will return that item
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) storage[1]).getItem();
        }
    }
    
    /**
     * This method calculates the position of the parent node
     * 
     * @param pos 
     */
    private int parent(int pos){
        return pos/2;
    }
    
    /**
     * This method calculates the left child position
     * 
     * @param pos
     */
    private int leftChild(int pos){
        return 2*pos;
    }
    
    /**
     * This method calculates the right child position
     * 
     * @param pos
     */
    private int rightChild(int pos){
        return (2*pos)+1;
    }
    
    /**
     * This method takes in a value and 
     * if that value meets the conditions it will return true 
     * if it doesn't it will return false
     * 
     * @param pos
     */
    private boolean isLeaf(int pos){
        if(pos >= (capacity/2) && pos <=capacity){
            return true;
        }
        return false;
    }
   
    /**
     * This method swaps two objects in the list
     * 
     * @param fpos
     * @param spos
     */
    private void swap(int fpos, int spos){
        //stores the item and priority in new varaibles
        Object temp = ((PriorityItem<T>) storage[fpos]).getItem();
        int p = ((PriorityItem<T>) storage[fpos]).getPriority();
        Object temp1 = ((PriorityItem<T>) storage[spos]).getItem();
        int p1 = ((PriorityItem<T>) storage[spos]).getPriority();
        //Swaps the items araound
        storage[fpos] = new PriorityItem<>(temp1,p1);
        storage[spos] = new PriorityItem<>(temp,p);
    }
    
    /**
     * This method is called when an item is removed 
     * it sorts the tree out to find the largest node
     * 
     * @param pos
     */
    private void maxHeapIFy(int pos){
        if(!isLeaf(pos)){
            if(((PriorityItem<T>) storage[rightChild(pos)])!=null){
                if(((PriorityItem<T>) storage[pos]).getPriority() < ((PriorityItem<T>) storage[leftChild(pos)]).getPriority() || ((PriorityItem<T>) storage[pos]).getPriority() < ((PriorityItem<T>) storage[rightChild(pos)]).getPriority()){
                    if(((PriorityItem<T>) storage[leftChild(pos)]).getPriority() > ((PriorityItem<T>) storage[rightChild(pos)]).getPriority()){
                        swap(pos, leftChild(pos));
                        maxHeapIFy(leftChild(pos));
                    }else{
                        swap(pos, rightChild(pos));
                        maxHeapIFy(rightChild(pos));
                    }
                }
            }else if(((PriorityItem<T>) storage[rightChild(pos)])==null && ((PriorityItem<T>) storage[leftChild(pos)])!=null){
                if(((PriorityItem<T>) storage[leftChild(pos)]).getPriority() > ((PriorityItem<T>) storage[pos]).getPriority()){
                    if(((PriorityItem<T>) storage[leftChild(pos)]).getPriority() >=0){
                        swap(pos, leftChild(pos));
                        maxHeapIFy(leftChild(pos));
                    }else{
                        swap(pos, rightChild(pos));
                        maxHeapIFy(rightChild(pos));
                    }
                }
            }else if(((PriorityItem<T>) storage[rightChild(pos)])==null && ((PriorityItem<T>) storage[leftChild(pos)])==null){
                
            }
        }
    }
    
    /**
     * This method adds and item to the heap
     * 
     * @param add
     */
    @Override
    public void add(T item, int priority){
       storage[++tailIndex] = new PriorityItem<>(item, priority);
       int current = tailIndex;
       while(current > 1 && ((PriorityItem<T>) storage[current]).getPriority() > ((PriorityItem<T>) storage[parent(current)]).getPriority()){
           swap(current,parent(current));
           current = parent(current);
       }
    }
    
    /**
     * This will print out the values stored in the array
     */
    public String toString(){
        String result = " ";
        for(int i = 1; i <= tailIndex / 2; i++){
            result +=  "PARENT : " + storage[i] + " LEFT CHILD : " + storage[2 * i] + " RIGHT CHILD :" + storage[2 * i + 1];
            result += System.lineSeparator();
        }
        return result;
    }
    
    /**
     * This method removes the highest node
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if(tailIndex>=1){
            storage[1] = storage[tailIndex--];
            maxHeapIFy(1);
        }else{
            System.out.println("Array is empty.");
        }
    }
    
    /**
     * This method checks if the array is empty 
     */
    @Override
    public boolean isEmpty() {
        if(tailIndex>=1){
            return false;
        }else if (tailIndex <1){
            return true;
        }
        return false;
    }
    
}
