package Greedy_Algo.Minimum_No_Platform_reuired_Railway;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        int arr[] = {1000, 935, 1100};
        int dep[] = {1200, 1240, 1130};

        int m = arr.length;


        int[][] newarr = new int[m][2];

        for (int i = 0; i < m; i++) {
            newarr[i][0] = arr[i]; // arrival time
            newarr[i][1] = dep[i]; // departure time
        }

        // 🔹 Sorting by arrival time
        Arrays.sort(newarr, (a, b) -> a[0] - b[0]);

        int maxPlatforms = 1; // 🔹 final answer

        // 🔹 Outer loop: pick each train
        // WHY: For every train, check how many are already running
        for (int i = 0; i < m; i++) {

            int count = 1; // 🔹 current train needs 1 platform

            // 🔹 Inner loop: check all previous trains
            // WHY: To find overlapping trains
            for (int j = 0; j < i; j++) {

                // 🔹 Overlap condition
                // WHY: If previous train hasn't departed yet
                if (newarr[j][1] >= newarr[i][0]) {
                    count++; // need one more platform
                }
            }

            // 🔹 Track maximum platforms needed
            // WHY: We want peak requirement
            maxPlatforms = Math.max(maxPlatforms, count);
        }

        // 🔹 Output result
        System.out.println("Minimum Platforms Required = " + maxPlatforms);
    }
}