package DP.FrogJump;

public class FrogJumpKDistance {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int n = arr.length;
        int k = 1;
        int[] dp = new int[n];

        dp[0] = 0; // cost to stay at first stone = 0

        for (int i = 1; i < n; i++) {
            int ministep = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {  // check if valid jump
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    ministep = Math.min(ministep, jump);
                }
            }
            dp[i] = ministep;
        }

        System.out.println(dp[n - 1]); // minimum cost to reach last stone
    }
}
