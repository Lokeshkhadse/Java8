package DP.Target_Sum;

public class Rec_Target_Sum {
    public static void main(String[] args) { //+ , - assign number to element and sum == target find how many ways
//        int[] arr = {1,1,1,1,1};
//        int target = 3;

        int[] arr = {1,1,2,3};
        int target = 1;

        int ways = findTargetSumWays(arr,target);
        System.out.println(ways);

    }
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int cnt = findWays(0,nums,target,0);
        return cnt;

    }
    public static int findWays(int index , int[] nums,int target, int sum){
        if(index == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0 ;
            }
        }

        int pos = findWays(index+1,nums,target,sum + nums[index]);
        int neg = findWays(index+1,nums,target,sum-nums[index]);

        return pos+neg;
    }
}
