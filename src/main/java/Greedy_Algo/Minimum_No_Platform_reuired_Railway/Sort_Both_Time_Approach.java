package Greedy_Algo.Minimum_No_Platform_reuired_Railway;

import java.util.Arrays;

public class Sort_Both_Time_Approach {
    public static void main(String[] args) {

        // 🔹 Input
        int arr[] = {1000, 935, 1100};
        int dep[] = {1200, 1240, 1130};

        // 🔹 Step 1: Sort both array

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0; // arrival pointer
        int j = 0; // departure pointer

        int cnt = 0;      // current platforms in use
        int maxcnt = 0;   // maximum platforms needed

        // 🔹 Step 2: Traverse arrivals
        while (i < arr.length) {

            // 🔹 If train arrives before previous departs
            if (arr[i] <= dep[j]) {
                cnt++;   // need one more platform
                i++;
            }
            // 🔹 If train departs first
            else {
                cnt--;   // free one platform
                j++;
            }

            // 🔹 Track maximum platforms
            maxcnt = Math.max(maxcnt, cnt);
        }

        // 🔹 Output
        System.out.println("Minimum Platforms Required = " + maxcnt);
    }
}
