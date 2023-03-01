package alg.sort;

/*
 * Insertion, Selection, Bubble Sort
*/

public class NsqSort {
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //select an element and place it at correct position in our sorted order
    public static void insertionSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            int j = i;
            while(j>0 && nums[j]<nums[j-1]){
                swap(nums, j-1, j);
                j--;
            }
        }
    }

    //select minimum of array in each iteration and put it at the beginning
    public static void selectionSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            int minPos = i;
            for(int j=i; j<nums.length; j++){
                if(nums[j]<nums[minPos])
                    minPos = j;
            }
            swap(nums, minPos, i);
        }
    }

    //in each iteration keep swapping until the element(bubble) reaches the end
    public static void bubbleSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1])
                    swap(nums, j, j+1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,4,6,2,6,9,1,2,7};
        
        //selectionSort(arr);
        //insertionSort(arr);
        bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i +" ");
        }
    }
}