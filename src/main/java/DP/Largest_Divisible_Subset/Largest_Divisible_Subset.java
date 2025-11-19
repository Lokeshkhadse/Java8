package DP.Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.List;

//Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
//
//answer[i] % answer[j] == 0, or
//answer[j] % answer[i] == 0
//If there are multiple solutions, return any of them.


public class Largest_Divisible_Subset {
    public static void main(String[] args) {
        int nums[] =  {1,2,4,8};
        List<Integer> ans = largestDivisibleSubset(nums);
        System.out.println(ans);
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> data = function(0, nums, new ArrayList<>(), ans);

        List<List<Integer>> finalAns = new ArrayList<>();

        // store all valid divisible subsets
        for (List<Integer> current : data) {
            if (isDivided(current)) {
                finalAns.add(new ArrayList<>(current));
            }
        }

        // select the largest subset
        List<Integer> best = new ArrayList<>();

        for (List<Integer> subset : finalAns) {
            if (subset.size() > best.size()) {
                best = subset;
            }
        }

        return best;
    }

    public static boolean isDivided(List<Integer> list) {

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i + 1; j < list.size(); j++) {

                int a = list.get(i);
                int b = list.get(j);

                // Correct divisible condition:
                // at least one direction must divide
                if (!(a % b == 0 || b % a == 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<List<Integer>> function(int index, int[] nums,
                                               List<Integer> list,
                                               List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return ans;
        }

        // include current number
        list.add(nums[index]);
        function(index + 1, nums, list, ans);

        // exclude current number
        list.remove(list.size() - 1);
        function(index + 1, nums, list, ans);

        return ans;
    }
}
