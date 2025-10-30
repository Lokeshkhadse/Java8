package DP.Minimum_Coins;


public class Tab_Minimum_coins {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount  = 11;

        int res = coinChange(coins,amount);
        System.out.println(res);
    }
    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;


        int dp[][] = new int[n][amount+1];

        // Base case: when index = 0
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = (int) 1e9;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= amount; target++) {
                // not pick the coin
                int notPick = dp[index - 1][target];

                // pick the coin (if possible)
                int pick = (int) 1e9;
                if (coins[index] <= target) {
                    pick = 1 + dp[index][target - coins[index]];
                }

                dp[index][target] = Math.min(notPick, pick);
            }
        }


            int ans = dp[n - 1][amount];
            if (ans >= (int)1e9) return -1;
            return ans;
    }

}
