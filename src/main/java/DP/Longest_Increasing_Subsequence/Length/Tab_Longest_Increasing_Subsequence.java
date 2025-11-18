package DP.Longest_Increasing_Subsequence.Length;

import java.util.Arrays;

public class Tab_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = lengthOfLIS(nums);
        System.out.println("Longest_Increasing_Subsequence is -> " + ans);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;


        int dp[][] = new int[n+1][n+1];

        for(int index = n-1;index>=0;index--){
            for(int prevIndex = index-1;prevIndex>=-1;prevIndex--){

                int nottake = dp[index + 1][prevIndex+1];

                int take = Integer.MIN_VALUE;

                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + dp[index + 1][index+1];
                }

                dp[index][prevIndex + 1] = Math.max(nottake, take);
            }
        }
        return dp[0][-1+1];
    }

}
