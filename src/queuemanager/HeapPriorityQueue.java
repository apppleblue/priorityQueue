package queuemanager;

/**
 *
 * @author Uzzy
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T>{
        private Object[] storage;
        private int capacity;
        private int tailIndex;
    
    public HeapPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        tailIndex = 0;
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) storage[1]).getItem();
        }
    }
    
    private int parent(int pos){
        //int h = pos/2;
        //System.out.println(h+"h");
        return pos/2;
    }
    
    private int leftChild(int pos){
        return 2*pos;
    }
    
    private int rightChild(int pos){
        return (2*pos)+1;
    }
    
    private boolean isLeaf(int pos){
        if(pos >= (capacity/2) && pos <=capacity){
            return true;
        }
        return false;
    }
    /*
    private void swap(int fpos, int spos){
        //get the properties and the items and swap them in here
        System.out.println("fpos:"+fpos+", ypos:"+spos);
        Object xp = ((PriorityItem<T>) storage[fpos]).getPriority();
        Object xi = ((PriorityItem<T>) storage[fpos]).getItem();
                System.out.println("XP:"+xp+", XI:"+xi);
        Object yp = ((PriorityItem<T>) storage[spos]).getPriority();
        Object yi = ((PriorityItem<T>) storage[spos]).getItem();
                        System.out.println("YP:"+yp+", YI:"+yi);
        
        Object tmp;
        Object tmp1;
        
        tmp = xp;
        xp = yp;
        yp = tmp;
        
        tmp1 = xi;
        xi = yi;
        yi = tmp1;
    }
    
    private void maxHeapIf(int pos){
        if(!isLeaf(pos)){
            if(((PriorityItem<T>) storage[pos]).getPriority() < ((PriorityItem<T>) storage[leftChild(pos)]).getPriority() || ((PriorityItem<T>) storage[pos]).getPriority() < ((PriorityItem<T>) storage[rightChild(pos)]).getPriority()){
                if(((PriorityItem<T>) storage[leftChild(pos)]).getPriority() > ((PriorityItem<T>) storage[rightChild(pos)]).getPriority()){
                    swap(pos, leftChild(pos));
                    maxHeapIf(leftChild(pos));
                }else{
                    swap(pos, rightChild(pos));
                    maxHeapIf(rightChild(pos));
                }
            }
        }
    }
*/
    
    @Override
    public void add(T item, int priority){
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            //throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;
                while (i > 0 && ((PriorityItem<T>) storage[i - 1]).getPriority() < priority) {
                    storage[i] = storage[i - 1];
                    i = i - 1;
                }
            storage[i] = new PriorityItem<>(item, priority);
        }
        tailIndex = tailIndex + 1;
    }
    
    /*
    public void maxHeap(){
        for(int pos = (capacity / 2); pos >= 1; pos--){
            maxHeapIf(pos);
        }
    }
    */
    
    public String toString(){
       String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result;
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        for(int i = 1; i <= capacity / 2; i++) {
                System.out.println(
                    " PARENT : " + storage[i] + " LEFT CHILD : " + storage[2 * i] + " RIGHT CHILD :" + storage[2 * i + 1]);
                System.out.println();
        }
         
        /*
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i < tailIndex; i++) {
                storage[i] = storage[i + 1];
            }
            tailIndex = tailIndex - 1;
        }
                */
    }
    
    @Override
    public boolean isEmpty() {
        return capacity==0;
    }
    
    public void print() {
            
    }
    
}
