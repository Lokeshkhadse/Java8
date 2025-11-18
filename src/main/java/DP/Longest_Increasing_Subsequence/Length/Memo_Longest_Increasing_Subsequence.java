package DP.Longest_Increasing_Subsequence.Length;

import java.util.Arrays;

public class Memo_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = lengthOfLIS(nums);
        System.out.println("Longest_Increasing_Subsequence is -> " + ans);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int prevIndex = -1;

        int dp[][] = new int[n][n+1];  // prevIndex shifted by +1

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return function(0, prevIndex, nums, dp);
    }

    public static int function(int index, int prevIndex, int[] nums, int[][] dp) {

        if (index == nums.length) return 0;


        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        // not take
        int nottake = function(index + 1, prevIndex, nums, dp);

        // take
        // set prevIndex to currentIndex || for first element add for we add prevIndex == -1
        int take = Integer.MIN_VALUE;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + function(index + 1, index, nums, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(nottake, take);
    }
}
