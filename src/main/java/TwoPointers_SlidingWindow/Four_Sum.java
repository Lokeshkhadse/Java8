package TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums,target);
        System.out.println(ans);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>>ans  = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0, r=l+1 , k = r+1, m = n-1;

        while(l < n-3){
            r = l+1;


            while(r < n-2){
                k = r+1;
                m = n-1;

                while(k < m){
                    long sum = (long) nums[l] + nums[r] + nums[k] + nums[m];

                    if(sum == target){
                        ans.add(Arrays.asList(nums[l],nums[r],nums[k],nums[m]));

                        while(k < m && nums[k] == nums[k+1]) k++;
                        while(k <m && nums[m] == nums[m-1]) m--;

                        k++;
                        m--;
                    }else if( sum < target){
                        k++;
                    }else{
                        m--;
                    }
                }

                while(r < n-2 && nums[r] == nums[r+1]) r++;

                r++;
            }
            while(l < n-3 && nums[l] == nums[l+1]) l++;
            l++;
        }
        return ans;
    }
}
