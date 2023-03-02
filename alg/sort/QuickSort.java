package alg.sort;

public class QuickSort {

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int partition(int[] nums, int l, int r, int pos){
        int newPos = l;
        
        for(int i = l; i<r; i++){
            if(nums[i]<=nums[pos]){
                swap(nums,i,newPos);
                newPos++;
            }
        }
        swap(nums, pos, newPos);

        return newPos;
    }
    private static void quicksort(int[] nums, int l, int r){
        if(l>=r) return;
        int pivot = r;

        int pos = partition(nums, l, r, pivot);

        quicksort(nums, l, pos-1);
        quicksort(nums, pos+1, r);
    
    }
    public static void main(String[] args) {
        int[] arr = {9,5,2,1,4,7,3,3,4};
        quicksort(arr , 0, arr.length-1);

        for(int a: arr)
            System.out.print(a+" ");
    }
}

