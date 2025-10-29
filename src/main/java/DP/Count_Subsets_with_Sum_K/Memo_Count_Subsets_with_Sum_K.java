package DP.Count_Subsets_with_Sum_K;

import java.util.Arrays;

public class Memo_Count_Subsets_with_Sum_K {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int target = 4;

        int dp[][] = new int[arr.length][target + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);


        int cnt =  subsetSumToK(arr.length-1,target,arr,dp);
        System.out.println(cnt);

    }
    public static int subsetSumToK(int index,int target,int[] arr,int[][] dp){
        if(target == 0) return 1;

        if(index == 0) return (arr[index] == target) ? 1: 0;

        if(dp[index][target] != -1) return dp[index][target];

        int nottakecnt = subsetSumToK(index-1,target,arr,dp);
        int takecnt = 0;

        if(arr[index] <= target){
            takecnt = subsetSumToK(index-1,target-arr[index],arr,dp);
        }
        return dp[index][target] = nottakecnt + takecnt;
    }
}
