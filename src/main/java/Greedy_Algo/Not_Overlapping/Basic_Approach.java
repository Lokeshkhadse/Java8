package Greedy_Algo.Not_Overlapping;

import java.util.Arrays;

public class Basic_Approach {
    public static void main(String[] args) {

        int arr[][] = {{1,2},{2,3},{3,4},{1,3}};

        // Step 1: Sort by end time
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        // Step 2: Pick first interval
        int count = 1;
        int lastEnd = arr[0][1];

        // Step 3: Check remaining
        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] >= lastEnd) { // >= endtime and next startime if same want // > if not same want
                count++;
                lastEnd = arr[i][1];
            }
        }

        System.out.println("Maximum non-overlapping intervals: " + count);
    }
}