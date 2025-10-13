package DP.SubsetSumEqulaToK.Convert_TwoSubset_EqualsTo_SameSum;

import java.util.Arrays;

public class Convert_TwoSubset_EqualsTo_SameSum {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int target = 4;
        boolean ans = false;
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0) {
            System.out.println(ans);
            return;
        }

        ans = subsetSumToK(arr.length-1,sum/2,arr);
        System.out.println(ans);

    }
    public static boolean subsetSumToK(int index, int target, int arr[]){
        if(target == 0 ) return true;
        if(index == 0) return arr[0] == target;

        boolean notTake = subsetSumToK(index-1,target,arr);
        boolean take = false;

        if(arr[index] <=  target){
            take = subsetSumToK(index-1,target-arr[index],arr);
        }
        return notTake || take;

    }
}
