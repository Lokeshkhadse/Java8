package DP.Partitions_With_Given_Difference;

public class Tab_Partitions_With_Given_Difference {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int n = arr.length;
        int d = 1;
        System.out.println(countPartitions(n, d, arr)); // Output: 3
    }

    static final int MOD = (int) 1e9 + 7;

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // If difference is not possible or leads to a non-integer target
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0)
            return 0;

        int target = (totalSum - d) / 2;
        return countSubsets(arr, target);
    }

    // Count subsets that sum to target
    public static int countSubsets(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        // Base case: one way to make sum = 0 (pick nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                // Not take the current element
                dp[i][sum] = dp[i - 1][sum];

                // Take the current element if it fits
                if (arr[i - 1] <= sum) {
                    dp[i][sum] = (dp[i][sum] + dp[i - 1][sum - arr[i - 1]]) % MOD;
                }
            }
        }

        return dp[n][target];
    }


}
