package TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = threeSum(nums,target);
        System.out.println(ans);

    }
    public static List<List<Integer>> threeSum(int[] nums,int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int l  = 0 , r = l +1 , k = n-1;

        while( l < n-2){
            r = l+1;
            k = n-1;

            while( r < k){
                int sum  = nums[l] + nums[r] + nums[k];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[l],nums[r],nums[k]));

                    while( r < k && nums[r] == nums[r +1]) r++;
                    while(r < k && nums[k] == nums[k-1]) k--;

                    r++;
                    k--;
                }else if(sum < 0){
                    r++;
                }else{
                    k--;
                }
            }

            while(l < n-2 && nums[l] == nums[l+1])l++;

            l++;
        }

        return ans;
    }
}
