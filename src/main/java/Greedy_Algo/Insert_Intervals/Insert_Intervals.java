package Greedy_Algo.Insert_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Intervals {
    public static void main(String[] args) {

        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1️⃣ LEFT (no overlap)
        while(i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2️⃣ MIDDLE (merge overlap)
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // 3️⃣ RIGHT (remaining)
        while(i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert list to array
        int[][] result = res.toArray(new int[res.size()][]);

        // Print result
        System.out.println(Arrays.deepToString(result));
    }
}