package DP.Ninja_Training;

import java.util.*;

public class Tab_Ninja {

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

        // 🔹 Base Case: Fill for day 0
        dp[0][0] = Math.max(points[0][1], points[0][2]); // last = 0 → can't do task 0
        dp[0][1] = Math.max(points[0][0], points[0][2]); // last = 1 → can't do task 1
        dp[0][2] = Math.max(points[0][0], points[0][1]); // last = 2 → can't do task 2
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2])); // last = 3 → no restriction

        // 🔹 Build dp table for each day
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // initialize

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        // 🔹 Final answer → last day, with no restriction (3)
        return dp[n - 1][3];
    }
}
