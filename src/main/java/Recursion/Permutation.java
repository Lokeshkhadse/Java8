package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] index = new boolean[nums.length];

        permutations(nums, ans, list, index);

        return ans;
    }

    public static void permutations(int[] nums, List<List<Integer>> ans,
                                    List<Integer> list, boolean[] index) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (index[i] == false) {
                list.add(nums[i]);
                index[i] = true;

                permutations(nums, ans, list, index);

                // backtrack
                list.remove(list.size() - 1);
                index[i] = false;
            }
        }
    }
}
