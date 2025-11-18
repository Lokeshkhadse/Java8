package DP.Longest_Increasing_Subsequence.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rec_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = lengthOfLIS(nums);
        System.out.println("Longest_Increasing_Subsequence is -> " + ans);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

         function(0, nums, list, ans);

        List<List<Integer>> inc = ans.stream()
                .filter(sub -> isIncreasing(sub))
                .collect(Collectors.toList());


        int value = inc.stream().mapToInt(sub -> sub.size()).max().orElse(0);
        return value;

    }

    public static boolean isIncreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void function(int index, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        list.add(nums[index]);
        function(index + 1, nums, list, ans);
        list.remove(list.size() - 1);

        function(index + 1, nums, list, ans);


    }
}