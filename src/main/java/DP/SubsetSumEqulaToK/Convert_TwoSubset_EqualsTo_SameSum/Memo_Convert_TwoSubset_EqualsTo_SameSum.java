package DP.SubsetSumEqulaToK.Convert_TwoSubset_EqualsTo_SameSum;

import java.util.Arrays;

public class Memo_Convert_TwoSubset_EqualsTo_SameSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int sum = Arrays.stream(arr).sum();

        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }

        int target = sum / 2;
        Boolean[][] dp = new Boolean[arr.length][target + 1];

        boolean ans = subsetSumToK(arr.length - 1, target, arr, dp);
        System.out.println(ans);
    }

    public static boolean subsetSumToK(int index, int target, int arr[], Boolean[][] dp) {
        // base cases
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        // already computed
        if (dp[index][target] != null) return dp[index][target];

        // not take
        boolean notTake = subsetSumToK(index - 1, target, arr, dp);

        // take
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumToK(index - 1, target - arr[index], arr, dp);
        }

        // store result
        return dp[index][target] = take || notTake;
    }
}
