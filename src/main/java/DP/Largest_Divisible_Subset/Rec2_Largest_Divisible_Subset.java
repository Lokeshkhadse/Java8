package DP.Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
//
//answer[i] % answer[j] == 0, or
//answer[j] % answer[i] == 0
//If there are multiple solutions, return any of them.


public class Rec2_Largest_Divisible_Subset {
    public static void main(String[] args) {
        int nums[] =  {1,2,4,8};
        List<Integer> ans = largestDivisibleSubset(nums);
        System.out.println(ans);
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int index = 0 ;
        int prevIndex = -1;
        return function(index,-prevIndex,nums);

    }

    public static List<Integer> function(int index, int prevIndex ,int[] nums) {

        if(index == nums.length){
            return new ArrayList<>();
        }

        //notpick
        List<Integer>notpick = function(index+1,prevIndex,nums);

        //pick
        List<Integer>pick = new ArrayList<>();

        if(prevIndex == -1|| nums[index] % nums[prevIndex] == 0){
            pick = function(index+1,index,nums);
            pick.add(0,nums[index]);
        }

        return (notpick.size() > pick.size())?notpick:pick;


    }
}
