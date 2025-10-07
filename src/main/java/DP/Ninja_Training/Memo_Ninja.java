package DP.Ninja_Training;

import java.util.Arrays;

public class Memo_Ninja {

    public static void main(String[] args) {

        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;
        int result = ninjaTraining(n, points);
        System.out.println("Maximum Points = " + result); // Expected: 210
    }

    public static int ninjaTraining(int n, int[][] points) {

        int[][] dp = new int[n][4];

        // Fill 2D dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fun(n - 1, 3, points, dp);
    }

    public static int fun(int day, int last, int[][] points, int[][] dp) {

        // Base case: first day
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        // Check memoized value
        if (dp[day][last] != -1)
            return dp[day][last];

        int maxi = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + fun(day - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }

        return dp[day][last] = maxi;
    }
}
