package Greedy_Algo.Jump_Game_I_and_II.Jump_II;

import java.util.Arrays;

public class Jump_Game_II_Recurssion_DP {
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        int n  = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int res = canReach(arr, 0,dp);
        System.out.println("result is -> " + res);
    }

    public  static int canReach(int[] arr, int index,int dp[]) {
        int n = arr.length;

        // ✅ Base Case: reached or crossed last index
        if(index >= n - 1) return 0;
        if(dp[index] != -1) return dp[index];


        if(arr[index] == 0) return Integer.MAX_VALUE;

        int minSteps = Integer.MAX_VALUE;

        // 🔁 Try all possible jumps
        for(int jump = 1; jump <= arr[index]; jump++) {
            int steps = canReach(arr, index + jump,dp);

            if(steps != Integer.MAX_VALUE){
                minSteps = Math.min(minSteps,1+steps);
            }
        }
        return dp[index] = minSteps;
    }
}
