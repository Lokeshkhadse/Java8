package DP.MaximumNonAdjacentSum;

import java.util.ArrayList;
import java.util.Arrays;

public class maximumNonAdjacentSum_Tabulation {
    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 6, 6));
        System.out.println(maximumNonAdjacentSum(nums1)); //Output: 11

    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int dp[] = new int[n+1];
        dp[0] = nums.get(0);


        for(int i  = 1; i<n;i++){
            int pick  = nums.get(i);
            if(i > 1){
                pick = pick + dp[i-2];
            }
            int skip = 0 + dp[i-1];

            dp[i] = Math.max(pick,skip);
        }
        return dp[n-1];

    }
}
