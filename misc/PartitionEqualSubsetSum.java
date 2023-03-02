package misc;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum = sum+num;
        if(sum%2==1) return false;
        sum = sum/2;

        boolean[][] dp = new boolean[n+1][sum+1];

        for(int j=0; j<=sum; j++) dp[0][j] = false;
        for(int i=0; i<=n; i++) dp[i][0] = true;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j]  = dp[i-1][j];
                if(j>=nums[i-1])
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]); 
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }
        //System.out.print();
        return dp[n][sum];
        //return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
