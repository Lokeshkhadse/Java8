package TwoPointers_SlidingWindow.Adjacent_Increasing_Subarrays_Detection_I;

import java.util.Arrays;
import java.util.List;

public class Find_Max_K_Adjacent_Increasing_subarrays {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,5,7,8,9,2,3,4,3,1);
        int k = 3;
        int ans = hasIncreasingSubarrays(nums,k);
        System.out.println(ans);
    }

    public static int hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int currentInc = 1;
        int prevInc = 0;
        int maxK = 0;

        for(int i = 1 ; i<n;i++){
            if(nums.get(i) > nums.get(i-1)){
                currentInc++;
            }else{
                prevInc = currentInc;
                currentInc = 1;
            }

            maxK = Math.max(maxK,currentInc/2);
            maxK = Math.max(maxK,Math.min(currentInc,prevInc));


        }
        return maxK;
    }

}
