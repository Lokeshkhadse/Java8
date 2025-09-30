package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class maximum_Non_Adjacent_Sum {
    public static void main(String[] args) {

        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 6, 6));
        System.out.println(maximumNonAdjacentSum(nums1)); //Output: 11

        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(4, 2, 4));
        System.out.println(maximumNonAdjacentSum(nums2));  //Output: 8

    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        return helper(nums, 0); // start recursion at index 0
    }

    // Recursive helper function
    public static int helper(ArrayList<Integer> nums, int index) {
        if (index >= nums.size()) {
            return 0;
        }

        // Option 1: pick current element and skip next
        int pick = nums.get(index) + helper(nums, index + 2);

        // Option 2: skip current element
        int skip = helper(nums, index + 1);


        return Math.max(pick, skip);
    }

}
