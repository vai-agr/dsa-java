package ds;


public class MaxHeap {
    
    private int[] arr;
    int maxSize,size;

    public MaxHeap(int maxSize){
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
    public int getMax(){
        return arr[0];
    }

    //correct the heap by moving smaller elements towards bottom
    public void maxHeapify(int i){
        int left = leftChild(i), right = rightChild(i);
        int greater = i;

        if(left<size() && arr[left]>arr[i])
            greater = left;
        if(right<size() && arr[right]>arr[greater])
            greater = right;
        
        if(greater!=i){
            swap(i,greater);
            maxHeapify(greater);
        }
    }

    //delete the root element or max element
    public void delete(){
        arr[0] = arr[size-1];
        size--;
        maxHeapify(0);
    }

    //insert a new element
    public void insert(int val){

        if(size==maxSize){
            System.out.println("ERROR: Max heap size reached");
            return;
        }
            
        arr[size++] = val;
        int index = size-1;

        
        while(index>0 && arr[index]>arr[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void updateKey(int i, int newVal){}
    public void deleteKey(int i){}

    public static void main(String[] args) {
        int maxSizeofHeap = 20;
        MaxHeap maxHeap = new MaxHeap(maxSizeofHeap);
        int[] nums = {4,5,1,3,7,9};
        for(int num: nums){
            maxHeap.insert(num);
            System.out.println(maxHeap.getMax());
        }
        maxHeap.delete();
        System.out.println(maxHeap.getMax());
        maxHeap.delete();
        System.out.println(maxHeap.getMax());
    }
}
