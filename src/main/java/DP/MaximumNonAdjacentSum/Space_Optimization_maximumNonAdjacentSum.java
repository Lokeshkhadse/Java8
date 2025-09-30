package DP.MaximumNonAdjacentSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Space_Optimization_maximumNonAdjacentSum {
    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 6, 6));
        System.out.println(maximumNonAdjacentSum(nums1));

    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0 ;


        for(int i  = 1; i<n;i++){
            int pick  = nums.get(i);
            if(i > 1){
                pick = pick + prev2;
            }
            int skip = 0 + prev;

            int current = Math.max(pick,skip);
            prev2 = prev;
            prev = current;

        }
        return prev;

    }
}
