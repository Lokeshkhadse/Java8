package DP.Longest_Increasing_Subsequence.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rec2_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = lengthOfLIS(nums);
        System.out.println("Longest_Increasing_Subsequence is -> " + ans);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int prevIndex = -1;
        int data = function(0, prevIndex, nums );
        return data;

    }


    public static int function(int index, int prevIndex, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        // not take
        int nottake = 0 + function(index+1,prevIndex,nums);


        //take & set prevIndex to currentIndex || for first element add for we add prevIndex == -1
        int take = Integer.MIN_VALUE;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
               take = 1 + function(index+1,index,nums);
        }

        return Math.max(nottake,take);
    }
}