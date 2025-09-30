package DP;

public class House_Robber_II {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        int[] leftSkip = new int[n];
        int[] rightSkip = new int[n];

        for(int i = 0 ;i<n;i++){
            if(i != 0) leftSkip[i] = nums[i];
            if(i != n-1) rightSkip[i] = nums[i];

        }

        return Math.max(helper(leftSkip) , helper(rightSkip));

    }
    public static int helper(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n+1];
        dp[0] = arr[0];


        for(int i  = 1; i<n;i++){
            int pick  = arr[i];
            if(i > 1){
                pick = pick + dp[i-2];
            }
            int skip = 0 + dp[i-1];

            dp[i] = Math.max(pick,skip);
        }
        return dp[n-1];

    }
}
