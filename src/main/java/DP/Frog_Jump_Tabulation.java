package DP;

import java.util.Arrays;

public class Frog_Jump_Tabulation {
//    public static void main(String[] args) {
//        int[] arr = {10,20,30,10};
//        int n = arr.length;
//        int[] dp = new int[n+1];
//
//
//        dp[0] = 0 ;
//
//        for(int i  = 1 ;i<n;i++){
//            int firstStep = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
//            int secondStep = Integer.MAX_VALUE;
//            if(i > 1){
//                secondStep = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
//            }
//
//            dp[i] = Math.min(firstStep,secondStep);
//        }
//       System.out.println(dp[n-1]);
//    }

    //one more approach

    public static void main(String[] args) {
        int[] arr = {10,20,30,10};
        int n = arr.length;
        int prev = 0 ;
        int prev2 = 0;

        for(int i  = 1 ;i<n;i++){
            int firstStep = prev + Math.abs(arr[i] - arr[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if(i > 1){
                secondStep = prev2 + Math.abs(arr[i] - arr[i-2]);
            }

            int current = Math.min(firstStep,secondStep);
            prev2 = prev;
            prev = current;
        }
        System.out.println(prev);
    }

}
