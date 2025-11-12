package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res  = permute(arr);
        System.out.println(res);
        System.out.println(res.size());

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] index = new boolean[nums.length];

        finaPermutation(nums, ans, list, index);
        return ans;

    }
    public static void finaPermutation(int[] nums, List<List<Integer>> ans,List<Integer> list,boolean[] index) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (index[i] == false) {
                list.add(nums[i]);   //take
                index[i] = true;
                finaPermutation(nums, ans, list, index); //explore it

                list.remove((list.size() - 1)); // (backtrack step)
                index[i] = false;
            }
        }


    }
}





