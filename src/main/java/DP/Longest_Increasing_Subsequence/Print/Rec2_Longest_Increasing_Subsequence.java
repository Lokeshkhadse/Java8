package DP.Longest_Increasing_Subsequence.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rec2_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        List<String> ans = lengthOfLIS(nums);
        System.out.println("Longest_Increasing_Subsequence is -> " + ans);
    }

    public static List<String> lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

         function(0, nums, list, ans);

        List<String> best = new ArrayList<>();
        int maxLen = 0;

        for (List<String> sub : ans) {
            if (isIncreasing(sub)) {
                if (sub.size() > maxLen) {
                    maxLen = sub.size();
                    best = sub;
                }
            }
        }
        return best;

    }

    public static boolean isIncreasing(List<String> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int prev = Integer.parseInt(arr.get(i - 1));
            int curr = Integer.parseInt(arr.get(i));

            if (curr <= prev) return false;
        }
        return true;
    }


    public static void function(int index, int[] nums, List<String> list, List<List<String>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return ;
        }

        list.add(String.valueOf(nums[index]));
        function(index + 1, nums, list, ans);
        list.remove(list.size() - 1);

        function(index + 1, nums, list, ans);


    }
}