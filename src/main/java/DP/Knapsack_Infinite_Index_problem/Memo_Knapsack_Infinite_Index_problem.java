package DP.Knapsack_Infinite_Index_problem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Memo_Knapsack_Infinite_Index_problem {
    public static void main(String[] args) {
//        int[] weight = {2, 3, 5};
//        int[] value = {50, 40, 60};
//
//        int bagWeight = 6;

        int[] weight = {5, 10, 15};
        int[] value = {10, 30, 20};
        int bagWeight = 20;

        int n = weight.length;

        int[][] dp = new int[n+1][bagWeight+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans = function(n-1,weight,value,bagWeight,dp);
        System.out.println(ans);

    }
    public static int function(int index , int[] weight,int[] value,int bagWeight,int dp[][]){
        if(index == 0){
            if(  weight[index] <= bagWeight){
                if( bagWeight % weight[index]  == 0) {
                    return value[index] * bagWeight / weight[index];
                }else{
                    return value[index];
                }
            }else{
                return 0;
            }
        }
        if(dp[index][bagWeight] != -1) return dp[index][bagWeight];

        int nottake = 0 + function(index-1,weight,value,bagWeight,dp);

        int take = Integer.MIN_VALUE;
        if(weight[index] <= bagWeight){
            take = value[index] + function(index,weight,value , bagWeight - weight[index],dp);
        }

        return dp[index][bagWeight] = Math.max(nottake,take);
    }
}
