package queuemanager;

/**
 *
 * @author Uzzy
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T>{
        private Object[] storage;
        private int capacity;
        public int tailIndex;
    
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
   
    private void swap(int fpos, int spos){
        Object temp;
        int p;
        temp = ((PriorityItem<T>) storage[fpos]).getItem();
        p = ((PriorityItem<T>) storage[fpos]).getPriority();
        
        Object temp1 = ((PriorityItem<T>) storage[spos]).getItem();
        int p1 = ((PriorityItem<T>) storage[spos]).getPriority();
        
        storage[fpos] = new PriorityItem<>(temp1,p1);
        storage[spos] = new PriorityItem<>(temp,p);
    }
    
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

    @Override
    public void add(T item, int priority){
       storage[++tailIndex] = new PriorityItem<>(item, priority);
       
       int current = tailIndex;
       while(current > 1 && ((PriorityItem<T>) storage[current]).getPriority() > ((PriorityItem<T>) storage[parent(current)]).getPriority()){
           swap(current,parent(current));
           current = parent(current);
       }
    }
    
    public String toString(){
        String result = " ";
        for(int i = 1; i <= tailIndex / 2; i++){
            result +=  "PARENT : " + storage[i] + " LEFT CHILD : " + storage[2 * i] + " RIGHT CHILD :" + storage[2 * i + 1];
            result += System.lineSeparator();
        }
        return result;
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        if(tailIndex>=1){
            storage[1] = storage[tailIndex--];
            maxHeapIFy(1);
        }else{
            System.out.println("Array is empty.");
        }
    }
    
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
