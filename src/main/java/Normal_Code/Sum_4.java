package Normal_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_4 {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums,target);
        System.out.println(ans);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target){
        int n = nums.length;
        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(nums); //{-2,-1,0,0,1,2}
        int a = 0,b = a+1,c = b+1,d = n-1;

        while(a < n-3){
            b = a+1;
            while(b < n-2){
                c = b+1;
                d = n-1;
                while(c < d){
                    int sum = nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));

                        while(c < d && nums[c] == nums[c+1]) c++;
                        while(c < d && nums[d] == nums[d-1]) d--;

                        c++;
                        d--;

                    }else if(sum < target){
                        c++;
                    }else{
                        d--;
                    }
                }
                while(b < n-2 && nums[b] == nums[b+1]) b++;
                b++;
            }
            while(a < n-3 && nums[a] == nums[a+1]) a++;
            a++;

        }
        return ans;
    }
}
