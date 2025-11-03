package DP.Infinite_coins_use_for_Target;

public class Tab_Infinite_coins_use_for_Target {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 5;
        int n = coins.length;

        int ans = function(n, coins, amount);
        System.out.println(ans);
    }

    public static int function(int n, int[] coins, int target) {
        int dp[][] = new int[n][target + 1];

        // base case
        for (int t = 0; t <= target; t++) {
            dp[0][t] = (t % coins[0] == 0) ? 1 : 0;
        }

        // fill table
        for (int i = 1; i < n; i++) {
            for (int val = 0; val <= target; val++) {
                int notPick = dp[i - 1][val];
                int pick = 0;
                if (coins[i] <= val)
                    pick = dp[i][val - coins[i]]; // stay at i for infinite use
                dp[i][val] = notPick + pick;
            }
        }

        return dp[n - 1][target];
    }
}
