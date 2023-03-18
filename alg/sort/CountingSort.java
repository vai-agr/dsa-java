package alg.sort;

//works well when elements are in a range
public class CountingSort {
    
    public static void sort(int[] nums){

        int maxVal = 0;
        for(int num: nums)
            maxVal = Math.max(maxVal, num);
        

        int[] values = new int[maxVal+1];
        
        for(int num: nums){
            values[num]++;
        }

        for(int i=0,j=0; i<=maxVal; i++){
            while(values[i]-->0){
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
