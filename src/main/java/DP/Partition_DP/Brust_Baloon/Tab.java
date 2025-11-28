package DP.Partition_DP.Brust_Baloon;

public class Tab {
    public static void main(String[] args) {
        int[] baloonBrust = {3,1,5,8};
        int n = baloonBrust.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = baloonBrust[i];
        }

        int ans = func(arr, n);
        System.out.println("maximum balloon burst coins is -> " + ans);
    }

    public static int func(int[] arr, int n) {

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {

                int max = 0;

                for (int k = i; k <= j; k++) {

                    int coins =
                            arr[i - 1] * arr[k] * arr[j + 1] +
                                    dp[i][k - 1] +
                                    dp[k + 1][j];

                    max = Math.max(max, coins);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}
