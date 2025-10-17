package TwoPointers_SlidingWindow.Adjacent_Increasing_Subarrays_Detection_I;

import java.util.Arrays;
import java.util.List;

public class Aproach_2_Adjacent_Increasing_Subarrays_Detection_I {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,5,7,8,9,2,3,4,3,1);
        int k = 3;
        boolean ans = hasIncreasingSubarrays(nums,k);
        System.out.println(ans);
    }


     public static  boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
         int n = nums.size();

         // ✅ Ensure we don't go out of bounds
         for (int start = 0; start + 2 * k <= n; start++) {

             boolean firstcheck = isIncreasing(nums, start, start + k - 1);
             boolean nextcheck = isIncreasing(nums, start + k, start + 2 * k - 1);

             if (firstcheck && nextcheck) {
                 return true;
             }
         }
         return false;
     }

     public static boolean isIncreasing(List<Integer> nums, int i, int j) {
         for (int start = i; start < j; start++) {
             if (nums.get(start) >= nums.get(start + 1)) {
                 return false;
             }
         }
         return true;
     }
}
