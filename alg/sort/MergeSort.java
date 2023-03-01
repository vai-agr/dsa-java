package alg.sort;

public class MergeSort {
    
    private static void merge(int[] nums, int l, int mid, int r){
        int[] lArr = new int[mid-l+1], rArr = new int[r-mid];

        for(int i=l; i<=mid; i++)
            lArr[i-l] = nums[i];
            
        for(int j=mid+1; j<=r; j++)
            rArr[j-mid-1] = nums[j];
        
        int i=0,j=0,k=l;
        while(i<=mid-l && j<r-mid){
            if(rArr[j]<lArr[i]){
                nums[k] = rArr[j];
                j++;
            }
            else{
                nums[k] = lArr[i];
                i++;
            }
            k++;  
        }
        //no need to do below for right array as it will already be in correct place in nums
        while(i<=mid-l){
            nums[k] = lArr[i];
            i++;k++;
        }
    }
    public static void mergeSort(int[] arr, int l ,int r){
        if(l>=r) return;
        int mid = l+(r-l)/2;
        mergeSort(arr, l,mid);
        mergeSort(arr, mid+1,r);
        merge(arr, l, mid, r);
    }
    public static void main(String[] args) {
        int[] arr = {1,5,5,8,9,9,2,4,5,7,8,9};
        mergeSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
