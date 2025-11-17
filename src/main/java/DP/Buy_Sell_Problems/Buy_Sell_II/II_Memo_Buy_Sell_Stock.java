package DP.Buy_Sell_Problems.Buy_Sell_II;

import java.util.Arrays;

public class II_Memo_Buy_Sell_Stock {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int n = arr.length;

        // dp[index][buy] : store max profit from index with buy/sell state
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = func(0, arr, 1, dp);
        System.out.println(ans);
    }

    public static int func(int index, int[] arr, int buy, int[][] dp){
        if(index == arr.length){
            return 0;
        }

        // If already computed → return
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        int profit = 0;

        if(buy == 1){
            // Option 1: Buy stock
            int take = -arr[index] + func(index + 1, arr, 0, dp);

            // Option 2: Skip
            int notTake = func(index + 1, arr, 1, dp);

            profit = Math.max(take, notTake);

        } else {
            // Option 1: Sell stock
            int sell = arr[index] + func(index + 1, arr, 1, dp);

            // Option 2: Skip
            int notSell = func(index + 1, arr, 0, dp);

            profit = Math.max(sell, notSell);
        }

        return dp[index][buy] = profit;  // store result
    }
}
