package DP.Rod_Cutting;

public class Tab_Rod_Cutting {
    public static void main(String[] args) {
        int rod[] = {2, 5, 7, 8, 10};
        int n = 5;
        int index = rod.length - 1;
        int ans = cuttingRodFun(index, rod, n);
        System.out.println(ans); // Output: 12
    }

    public static int cuttingRodFun(int index, int[] rod, int n) {
        int dp[][] = new int[rod.length+1][n + 1];

        // Base case: if only length=1 available
        for (int N = 0; N <= n; N++) {
            dp[0][N] = N * rod[0];
        }

        // Fill dp table
        for (int ind = 1; ind < rod.length; ind++) {
            for (int N = 0; N <= n; N++) {
                int notCutRod = dp[ind - 1][N];

                int cutRod = Integer.MIN_VALUE;
                int rodLength = ind + 1;

                if (rodLength <= N) {
                    cutRod = rod[ind] + dp[ind][N - rodLength];
                }

                dp[ind][N] = Math.max(notCutRod, cutRod);
            }
        }

        return dp[index-1][n];
    }
}
