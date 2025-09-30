package DP.MaximumNonAdjacentSum;

import java.util.ArrayList;
import java.util.Arrays;

public class maximum_Non_Adjacent_Sum {
    public static void main(String[] args) {

        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 6, 6));
        System.out.println(maximumNonAdjacentSum(nums1)); //Output: 11



    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int dp[] = new int[n+1];
        dp[0] = 0 ;
        return helper(nums, 0,dp);
    }

    // Recursive helper function
    public static int helper(ArrayList<Integer> nums, int index,int[] dp) {
        if (index >= nums.size()) {
            return 0;
        }
        if(dp[index] != 0) return dp[index];

        // Option 1: pick current element and skip next
        int pick = nums.get(index) + helper(nums, index + 2,dp);

        // Option 2: skip current element
        int skip = helper(nums, index + 1,dp);


        dp[index] =  Math.max(pick, skip);
        return dp[index];
    }
}
