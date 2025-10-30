package DP.Minimum_Coins;

import java.util.Arrays;

public class Memo_Minimum_coins {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount  = 11;

        int res = coinChange(coins,amount);
        System.out.println(res);
    }
    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int index = n-1;

        int dp[][] = new int[n+1][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans = min_No_Of_Coin(index,coins,amount,dp);
        if (ans >= (int)1e9) return -1;
        return ans;
    }
    public static int min_No_Of_Coin(int index,int[] coins,int amount,int dp[][]){
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount / coins[index];
            }else{
                return (int) 1e9;
            }
        }

        if(dp[index][amount] != -1) return dp[index][amount];
        
        int notpick = 0 + min_No_Of_Coin(index-1,coins,amount,dp);

        int pick = (int)1e9;
        if(coins[index] <= amount){
            pick = 1 + min_No_Of_Coin(index,coins,amount-coins[index],dp);
        }

        return  dp[index][amount] = Math.min(notpick , pick);
    }

}
