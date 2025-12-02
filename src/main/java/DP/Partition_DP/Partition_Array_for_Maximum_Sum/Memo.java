package DP.Partition_DP.Partition_Array_for_Maximum_Sum;

import java.util.Arrays;

public class Memo {
    public static void main(String[] args) {
        int arr[] = {1,15,7,9,2,5,10};
        int k = 3;
        int n = arr.length;


        int dp[] = new int[n];
        Arrays.fill(dp , -1);

        int index =0 ;
        int ans = func(index,arr,k,dp);
        System.out.println("maximum sum after k partition is ->" + ans);
    }
    public static int func(int index,int arr[] , int k,int dp[]){
        if(index == arr.length){
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        int maxSum = Integer.MIN_VALUE;
        int maxElement = 0;
        int len = 0;


        for(int j = index;j<Math.min(arr.length,index+k);j++){
            len++;
            maxElement = Math.max(maxElement,arr[j]);

            int sum = len * maxElement + func(j+1,arr,k,dp);

            maxSum = Math.max(maxSum,sum);
        }
        return dp[index] = maxSum;
    }
}
