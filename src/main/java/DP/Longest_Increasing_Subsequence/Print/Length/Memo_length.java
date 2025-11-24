package DP.Longest_Increasing_Subsequence.Print.Length;

import java.util.Arrays;

public class Memo_length {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = nums.length;

        int index =0 ;
        int prevIndex = -1;

        int[][] dp = new int[n][n+1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans = func(index,prevIndex,nums,dp);
        System.out.println(ans);
    }

    public static int func(int index,int prevIndex,int[] nums,int dp[][]){
        if(index == nums.length){
            return 0;
        }

        if(dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];

        int notpick = 0 + func(index+1,prevIndex,nums,dp);

        int pick = Integer.MIN_VALUE;

        if(prevIndex == -1 || nums[index]>nums[prevIndex]){
            pick = 1 + func(index+1,index,nums,dp);
        }

        return dp[index][prevIndex+1] = Math.max(notpick,pick);
    }
}
