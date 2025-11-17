package DP.Buy_Sell_Problems.Buy_Sell_III;

import java.util.Arrays;

public class III_Memo_buy_sell {   // Only 2 transactions allowed
    public static void main(String[] args) {
        int stocks[] = {3,3,5,0,0,3,1,4};
        int n = stocks.length;

        int[][][] dp = new int[n][2][3];

        // Fill dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int maxProfit = function(0, 1, stocks, 2, dp);
        System.out.println("2 transactions and max profit -> " + maxProfit);
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
