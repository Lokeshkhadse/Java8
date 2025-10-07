package DP.Ninja_Training;

public class SpaceOpt_Ninja {
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

        int[] prev = new int[4];

        // 🔹 Base Case: Fill for day 0
        prev[0] = Math.max(points[0][1], points[0][2]); // last = 0 → can't do task 0
        prev[1] = Math.max(points[0][0], points[0][2]); // last = 1 → can't do task 1
        prev[2] = Math.max(points[0][0], points[0][1]); // last = 2 → can't do task 2
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2])); // last = 3 → no restriction

        // 🔹 Build dp table for each day
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];

            for (int last = 0; last < 4; last++) {
                int maxi = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        maxi = Math.max(maxi, point);
                    }
                }
                temp[last] = maxi;

            }
            prev = temp; // move to next day

        }

        // 🔹 Final answer → last day, with no restriction (3)
        return prev[3];
    }
}
