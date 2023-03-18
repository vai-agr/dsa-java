package alg.sort;

//works well when elements are uniformly distributed in a range
public class BucketSort {
    
    public static void sort(int[] nums){

        int maxVal = 0, n = nums.length;
        for(int num: nums)
            maxVal = Math.max(maxVal, num);
        

        int[] buckets = new int[maxVal+1];
        
        for(int num: nums){
            buckets[num]++;
        }

        for(int i=0,j=0; i<=maxVal; i++){
            while(buckets[i]-->0){
                nums[j] = i;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,7,3,8,7,4,5,0,1,5};
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
