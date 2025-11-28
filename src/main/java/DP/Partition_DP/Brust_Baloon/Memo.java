package DP.Partition_DP.Brust_Baloon;

import java.util.Arrays;

public class Memo {
    public static void main(String[] args) {
        int[] baloonBrust = {3,1,5,8};
        int n = baloonBrust.length;

        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[arr.length-1]= 1;

        for(int i= 0;i< baloonBrust.length;i++){
            arr[i+1] = baloonBrust[i];
        }

        int m = arr.length;

        int dp[][] = new int[m][m];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans = func(1,m-2,arr,dp);
        System.out.println("maximum baloon brust coins is ->" +  ans);
    }
    public static int func(int i , int j,int[] arr,int dp[][]){
        if(i > j) return 0 ;   // i == j i want process because this is single element and process it.

        if(dp[i][j] != -1 )return dp[i][j];

        int max = Integer.MIN_VALUE;

        for(int k = i ; k<=j;k++){
            int coins = arr[i-1] * arr[k] *arr[j+1] + func(i,k-1,arr,dp) + func(k+1,j,arr,dp);
            max = Math.max(max,coins);
        }
        return dp[i][j] = max;
    }
}
