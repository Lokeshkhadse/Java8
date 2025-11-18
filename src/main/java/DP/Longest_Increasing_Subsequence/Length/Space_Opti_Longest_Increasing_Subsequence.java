package DP.Longest_Increasing_Subsequence.Length;

import java.util.ArrayList;
import java.util.List;

public class Space_Opti_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = lengthOfLIS(nums);
        System.out.println("Longest_Increasing_Subsequence is -> " + ans);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] next = new int[n+1];
        int[] curr = new int[n+1];


        int dp[][] = new int[n+1][n+1];

        for(int index = n-1;index>=0;index--){
            for(int prevIndex = index-1;prevIndex>=-1;prevIndex--){

                int nottake = next[prevIndex+1];

                int take = Integer.MIN_VALUE;

                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + next[index+1];
                }

                curr[prevIndex + 1] = Math.max(nottake, take);
            }
            next = curr;
        }
        return next[0];
    }

}
