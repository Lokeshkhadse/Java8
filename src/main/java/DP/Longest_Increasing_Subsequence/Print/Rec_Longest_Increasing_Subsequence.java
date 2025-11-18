package DP.Longest_Increasing_Subsequence.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rec_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        List<Integer> ans = lengthOfLIS(nums);
        System.out.println("Longest_Increasing_Subsequence is -> " + ans);
    }

    public static List<Integer> lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        List<List<Integer>> data = function(0, nums, list, ans);

        List<List<Integer>> inc = data.stream()
                .filter(sub -> isIncreasing(sub))
                .collect(Collectors.toList());

        List<Integer> best = new ArrayList<>();
        int maxLen = 0;

        for (List<Integer> sub : inc) {
            if (sub.size() > maxLen) {
                maxLen = sub.size();
                best = sub;      // store largest increasing subsequence
            }
        }

        return best;


    }

    public static boolean isIncreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) <= arr.get(i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static List<List<Integer>> function(int index, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return ans;
        }

        list.add(nums[index]);
        function(index + 1, nums, list, ans);
        list.remove(list.size() - 1);

        function(index + 1, nums, list, ans);

        return ans;
    }
}