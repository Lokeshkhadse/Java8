package DP.Partition_DP.Matrix_Chain_Multiplication;

import java.util.Arrays;

public class Memo { //FIND MINIMAL MULTIPLICATION OPERATION
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50} ; //ABCD -> A *BCD , AB*CD , ABC*D
        int n = arr.length;

        int Startindex = 1;
        int EndIndex = n-1;

        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        int ans = func(Startindex,EndIndex,arr,dp);
        System.out.println("MINIMAL MULTIPLICATION OPERATION  -> " + ans);
    }

    public static int func(int i , int j,int arr[],int dp[][]){
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = (int)1e9;

        for(int k = i ;k<j;k++){
            int cost = arr[i-1] * arr[k] * arr[j] + func(i,k,arr,dp) + func(k+1,j,arr,dp);

            min = Math.min(min,cost);
        }
        return dp[i][j] = min;
    }
}
