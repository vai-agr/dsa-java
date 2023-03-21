package alg.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//works best when elements are uniformly distributed over a range
public class BucketSort {
    public static void sort(int[] nums, int n){
        int maxEl = Arrays.stream(nums).max().getAsInt();
        int minEl =  Arrays.stream(nums).min().getAsInt();
        int div = Math.ceilDiv(maxEl - minEl, n);

        List<Integer>[] buckets = new LinkedList[n];

        for(int i=0; i<n; i++){
            buckets[i] = new LinkedList<>();
        }

        //add elements to buckets
        for(int num: nums){
            buckets[(num-minEl)/div].add(num);
        }

        //sort each bucket
        for(int i=0; i<n; i++){
            Collections.sort(buckets[i]);
        }

        //enter sorted elements to original array
        for(int i=0, j=0; i<n; i++){
            for (int num : buckets[i]) {
                nums[j] = num;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {102, 198, 156, 123, 178, 199, 166, 143, 155, 187, 134, 123, 111, 108};
        int n = 10;   //number of buckets
        sort(arr, n);
        for(int el: arr)
            System.out.print(el + " ");
    }
}
