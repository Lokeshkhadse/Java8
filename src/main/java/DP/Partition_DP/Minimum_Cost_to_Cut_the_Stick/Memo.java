package DP.Partition_DP.Minimum_Cost_to_Cut_the_Stick;

import java.util.Arrays;

public class Memo {
    public static void main(String[] args) {
        int cuts[] = {1,3,4,5};
        int n = 7;

        int[] arr = new int[cuts.length+2];
        arr[0] = 0 ;  // for start it is i-1
        arr[arr.length-1] =  n;       //for wnd this is j+1;

        for(int i = 0 ; i< cuts.length;i++){
            arr[i+1] = cuts[i];
        }

        Arrays.sort(arr);

        int dp[][] = new int[arr.length][arr.length];

        for(int row[] :dp){
            Arrays.fill(row,-1);
        }

        int miniCostcuts = func(1,arr.length-2,arr,dp);

        System.out.println("minimum total cost of the cuts. -> " + miniCostcuts);
    }

    public static int func(int i , int j, int arr[],int dp[][] ){
          if(i > j) return 0;

          if(dp[i][j] != -1) return dp[i][j];

        int min = (int)1e9;

          for(int k  = i;k<=j;k++){
              int cost = arr[j+1]-arr[i-1] + func(i,k-1,arr,dp) + func(k+1,j,arr,dp);
              min = Math.min(min,cost);
          }
         return dp[i][j] = min;
    }

}
