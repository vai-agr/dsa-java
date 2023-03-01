package alg.sort;
import ds.MinHeap;

public class HeapSort extends MinHeap {

    public HeapSort(int maxSize) {
        super(maxSize);
    }

    /* add all elements in heap, get the min and
       keep deleting one by one to form sorted array */

    public void sortUsingMinHeap(int[] arr){
        int sz = arr.length;
        for(int num: arr)
            insert(num);
        
        while(sz-- >0){
            arr[arr.length-sz-1] = getMin();
            delete();
        }
    }

    public void sortInPlace(int[] arr){
        
    }
    public static void main(String[] args) {
        int[] nums = {7,4,0,1,5,7,2};
        HeapSort heapSort = new HeapSort(20);
        heapSort.sortUsingMinHeap(nums);
        for(int num: nums)
            System.out.print(num+" ");
    }

}
