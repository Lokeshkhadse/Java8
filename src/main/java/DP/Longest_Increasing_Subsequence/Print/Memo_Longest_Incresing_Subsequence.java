package DP.Longest_Increasing_Subsequence.Print;

import java.util.Arrays;

public class Memo_Longest_Incresing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = nums.length;

        String[][] dp = new String[n][n + 1];

        String ans = func(0, -1, nums, dp);

        System.out.println(ans.trim());   // final LIS
    }

    public static String func(int index, int prevIndex, int[] nums, String[][] dp) {

        if (index == nums.length) return "";

        if (dp[index][prevIndex + 1] != null)
            return dp[index][prevIndex + 1];

        // NOT TAKE
        String nottake = func(index + 1, prevIndex, nums, dp);

        // TAKE
        String take = "";
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = nums[index] + " " + func(index + 1, index, nums, dp);
        }

        // Count length by splitting (correct LIS length)
        int takeLen = take.isEmpty() ? 0 : take.trim().split(" ").length;
        int notLen  = nottake.isEmpty() ? 0 : nottake.trim().split(" ").length;

        return dp[index][prevIndex + 1] = (takeLen > notLen) ? take : nottake;
    }
}
