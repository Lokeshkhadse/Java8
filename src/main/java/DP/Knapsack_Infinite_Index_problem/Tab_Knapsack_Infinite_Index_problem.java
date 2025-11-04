package DP.Knapsack_Infinite_Index_problem;

import java.util.Arrays;

public class Tab_Knapsack_Infinite_Index_problem {
    public static void main(String[] args) {

        int[] weight = {5, 10, 15};
        int[] value = {10, 30, 20};
        int bagWeight = 20;

        int n = weight.length;

        int ans = function(n, weight, value, bagWeight);
        System.out.println(ans);
    }

    public static int function(int n, int[] weight, int[] value, int bagWeight) {
        int[][] dp = new int[n][bagWeight + 1];

        // base case
        for (int w = 0; w <= bagWeight; w++) {
            dp[0][w] = (w / weight[0]) * value[0];
        }

        // fill table
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= bagWeight; w++) {
                int notTake = dp[i - 1][w];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= w) {
                    take = value[i] + dp[i][w - weight[i]]; // stay at same i because infinite
                }
                dp[i][w] = Math.max(notTake, take);
            }
        }

        return dp[n - 1][bagWeight];
    }
}
