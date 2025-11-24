package DP.longest_Bitonic_Sequence.Length;

public class Rec_Longest_Bitonic_Sequence {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 5, 3, 2};  //  1 ,2,5,3,2
        int[] nums = {33 ,26, 38, 53, 58, 92};
        int answer = longestBitonicSequence(nums);
        System.out.println("Longest_Bitonic_Sequence is -> " + answer);
    }
    public static int longestBitonicSequence( int[] nums) {
        boolean phase = false ;
        int ans = func(0, -1, false, nums);
        return ans < 0 ? 0 : ans; // if no bitonic found → 0

        // phase false -> incresing order , true -> decreasing order
    }
    public static int func(int index ,int prevIndex,boolean phase,int[] nums){
        if(index == nums.length){
            return phase?0:Integer.MIN_VALUE;
        }

        int nottake = 0 + func(index+1,prevIndex,phase,nums);

        int take = Integer.MIN_VALUE;

        if(prevIndex == -1){
            take = 1 + func(index+1,index,phase,nums);
        }else{

            int incre = Integer.MIN_VALUE;
            int decre = Integer.MIN_VALUE;

            if(!phase && nums[index]>nums[prevIndex]){
                incre = 1 + func(index+1,index,false,nums);
            }

            if(nums[index] < nums[prevIndex]){
                decre = 1 + func(index+1,index,true,nums);
            }

            take = Math.max(incre,decre);
        }
        return Math.max(nottake,take);
    }
}
