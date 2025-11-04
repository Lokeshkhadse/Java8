package DP.Rod_Cutting;

import java.util.Arrays;

public class Memo_Rod_Cutting {
    public static void main(String[] args) {
        int rod[] = {2,5,7,8,10};
        int n = 5;
        int index = rod.length-1;

        int dp[][] = new int[index+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans = cuttingRodFun(index,rod,n,dp);
        System.out.println(ans);
    }
    public static int cuttingRodFun(int index ,int[] rod,int n,int dp[][]){
        if(index == 0){
            return n * rod[0];
        }
        if(dp[index][n] != -1) return dp[index][n];

        int notcutRod = 0 + cuttingRodFun(index-1,rod,n,dp);
        int cutRod = Integer.MIN_VALUE;
        int rodlength = index+1;

        if( rodlength <= n){
            cutRod = rod[index] + cuttingRodFun(index,rod,n-rodlength,dp);
        }

        return dp[index][n] = Math.max(notcutRod,cutRod);
    }
}

