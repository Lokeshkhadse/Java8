package DP.Longest_Increasing_Subsequence.Print.Length;

public class Rec_length {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = nums.length;

        int index =0 ;
        int prevIndex = -1;

        int ans = func(index,prevIndex,nums);
        System.out.println(ans);
    }

    public static int func(int index,int prevIndex,int[] nums){
        if(index == nums.length){
            return 0;
        }

        int notpick = 0 + func(index+1,prevIndex,nums);

        int pick = Integer.MIN_VALUE;

        if(prevIndex == -1 || nums[index]>nums[prevIndex]){
            pick = 1 + func(index+1,index,nums);
        }

        return Math.max(notpick,pick);
    }
}
