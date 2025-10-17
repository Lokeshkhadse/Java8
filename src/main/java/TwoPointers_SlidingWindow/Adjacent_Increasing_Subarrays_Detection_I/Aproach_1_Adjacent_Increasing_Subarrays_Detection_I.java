package TwoPointers_SlidingWindow.Adjacent_Increasing_Subarrays_Detection_I;

import java.util.Arrays;
import java.util.List;

public class Aproach_1_Adjacent_Increasing_Subarrays_Detection_I {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,5,7,8,9,2,3,4,3,1);
        int k = 3;
        boolean ans = hasIncreasingSubarrays(nums,k);
        System.out.println(ans);
    }

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int currentInc = 1;
        int prevInc = 0;

        for(int i = 1 ; i<n;i++){
            if(nums.get(i) > nums.get(i-1)){
                currentInc++;
            }else{
                prevInc = currentInc;
                currentInc = 1;
            }

            if(currentInc /2 >= k) return true;
            if(Math.min(currentInc,prevInc) >= k) return true;


        }
        return false;
    }

}
