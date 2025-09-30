package DP;

import java.util.Arrays;

public class Frog_Jump_Memoization {
    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = minValueJump(arr,n-1,dp);
        System.out.println("Minimum Energy: " + ans);
    }
    public static int minValueJump(int[] arr , int index,int[] dp){
        if(index == 0) return 0;
        if(dp[index] != -1) return dp[index];

        int onestep = minValueJump(arr,index-1,dp) + Math.abs(arr[index] - arr[index-1]);
        int twostep = Integer.MAX_VALUE ;
        if(index > 1){
            twostep = minValueJump(arr,index-2,dp) + Math.abs(arr[index] - arr[index-2]);
        }

        return dp[index] = Math.min(onestep,twostep);
    }
}
