package DP.Partition_DP.Partition_Array_for_Maximum_Sum;

public class Tab {
    public static void main(String[] args) {
        int arr[] = {1,15,7,9,2,5,10};
        int k = 3;

        int ans = func(arr,k);
        System.out.println("maximum sum after k partition is ->" + ans);
    }
    public static int func(int arr[] , int k){
        int n = arr.length;

        int dp[] = new int[n+1];

        for(int index = n-1;index>=0;index--){
            int maxSum = Integer.MIN_VALUE;
            int maxElement = 0;
            int len = 0;


            for(int j = index;j<Math.min(arr.length,index+k);j++){
                len++;
                maxElement = Math.max(maxElement,arr[j]);

                int sum = len * maxElement + dp[j+1];

                maxSum = Math.max(maxSum,sum);
            }
            dp[index] = maxSum;
        }

    return dp[0];

    }
}
