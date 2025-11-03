package DP.Infinite_coins_use_for_Target;

import java.util.Arrays;

public class Memo_Infinite_coins_use_for_Target {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount = 5;
        int n =  coins.length;

        int dp[][] = new int[n+1][amount+1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans = function(n-1,coins,amount,dp);
        if(ans < 1) System.out.println(0);

        System.out.println(ans);
    }
    public static int function(int index , int coins[], int target,int dp[][]){
        if(index == 0 ){
            if(target % coins[index] == 0)  return 1;
            else return 0;
        }
        if(dp[index][target] != -1) return dp[index][target];

        int notPick = function(index-1,coins,target,dp);

        int pick = 0;

        if(coins[index] <= target){
            pick = function(index,coins,target-coins[index],dp);
        }
        return dp[index][target] = notPick + pick;
    }
}
