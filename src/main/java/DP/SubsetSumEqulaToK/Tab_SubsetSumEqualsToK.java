package DP.SubsetSumEqulaToK;

public class Tab_SubsetSumEqualsToK {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int target = 4;

        boolean ans = subsetSumToK(arr.length, target, arr);
        System.out.println(ans);
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean dp[][] = new boolean[n][k + 1];

        // Base Case 1: target = 0 -> always true (empty subset)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base Case 2: only first element available
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP table
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;

                if (arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }
}
