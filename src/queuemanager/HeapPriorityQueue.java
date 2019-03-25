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
    
    private int parent(int pos){ 
        return pos / 2; 
    } 
    
    private int leftChild(int pos){
        return (2*pos);
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
    
    private void swap(int fpos, int spos){ 
        Object tmp; 
        tmp = ((PriorityItem<T>) storage[fpos]).getItem(); 
        storage[fpos] = ((PriorityItem<T>) storage[spos]).getItem(); 
        storage[spos] = tmp; 
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

    @Override
    public void add(T item, int priority){      
        storage[++tailIndex] = new PriorityItem<>(item, priority);
        int temp = ((PriorityItem<T>) storage[tailIndex]).getPriority();
        System.out.println(temp);
        
        if(parent(tailIndex)<=0){
            System.out.println("less");
        }else{
            System.out.println("more");
            while(priority>((PriorityItem<T>) storage[parent(tailIndex)]).getPriority()){
                System.out.print("moreee");
                ((PriorityItem<T>) storage[parent(tailIndex)]).getPriority();
            }
        }

     
    }
    
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
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) storage[1]).getItem();
        }
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
    

    
}
