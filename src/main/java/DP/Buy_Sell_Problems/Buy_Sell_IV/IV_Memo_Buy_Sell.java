package DP.Buy_Sell_Problems.Buy_Sell_IV;

import java.util.Arrays;

//You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
public class IV_Memo_Buy_Sell {
    public static void main(String[] args) {
        int stocks[] = {3,2,6,5,0,3};
        int n = stocks.length;
        int k = 2;

        int[][][] dp = new int[n][2][k+1];

        // Fill dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int maxProfit = function(0, 1, stocks, 2, dp);
        System.out.println("K transactions and max profit -> " + maxProfit);
    }

    public static int function(int index, int buy, int[] stocks, int transaction, int[][][] dp) {

        // Base case 1: no more transactions allowed
        if (transaction == 0) return 0;

        // Base case 2: index goes out of bounds
        if (index == stocks.length) return 0;

        // Memo check
        if (dp[index][buy][transaction] != -1) {
            return dp[index][buy][transaction];
        }

        int profit = 0;

        if (buy == 1) { // allowed to buy
            int take = -stocks[index] + function(index + 1, 0, stocks, transaction, dp);
            int notTake = function(index + 1, 1, stocks, transaction, dp);
            profit = Math.max(take, notTake);

        } else { // allowed to sell
            int sell = stocks[index] + function(index + 1, 1, stocks, transaction - 1, dp);
            int notSell = function(index + 1, 0, stocks, transaction, dp);
            profit = Math.max(sell, notSell);
        }

        return dp[index][buy][transaction] = profit;
    }
}
