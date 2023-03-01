package ds;

public class MinHeap {
    private int[] arr;
    int maxSize,size;

    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        size = 0;
    }
    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public boolean empty(){
        return size>0;
    }
    public int size(){
        return size;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return i*2+1;
    }
    private int rightChild(int i){
        return i*2+2;
    }
    public int getMin(){
        return arr[0];
    }

    //correct the heap by moving greater elements towards bottom(smaller towards top)
    public void minHeapify(int i){
        int left = leftChild(i), right = rightChild(i);
        int smaller = i;

        if(left<size() && arr[left]<arr[i])
            smaller = left;
        if(right<size() && arr[right]<arr[smaller])
            smaller = right;
        
        if(smaller!=i){
            swap(i,smaller);
            minHeapify(smaller);
        }
    }

    //delete the root element or max element
    public void delete(){
        arr[0] = arr[size-1];
        size--;
        minHeapify(0);
    }

    //insert a new element
    public void insert(int val){

        if(size==maxSize){
            System.out.println("ERROR: Maximum heap size reached");
            return;
        }
            
        arr[size++] = val;
        int index = size-1;

        
        while(index>0 && arr[index]<arr[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void updateKey(int i, int newVal){}
    public void deleteKey(int i){}

    public static void main(String[] args) {
        int maxSizeofHeap = 20;
        MinHeap minHeap = new MinHeap(maxSizeofHeap);
        int[] nums = {4,5,1,3,7,4};
        for(int num: nums){
            minHeap.insert(num);
            System.out.println(minHeap.getMin());
        }
        minHeap.delete();
        System.out.println(minHeap.getMin());
        minHeap.delete();
        System.out.println(minHeap.getMin());
        minHeap.delete();
        System.out.println(minHeap.getMin());
    }
}
