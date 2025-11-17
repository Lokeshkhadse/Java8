package DP.Buy_Sell_Problems.Cooldown_Buy_Sell_UnlimitedTransaction;


//after sell next day you won't buy after next to next day you can buy;

import java.util.Arrays;

public class Memo_Cooldown_Buy_Sell_UnlimitedTransaction {
    public static void main(String[] args) {
        int arr[] = {1,2,3,0,2};
        int buy = 1;
        int index = 0 ;

        int dp[][] = new int[arr.length][2];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        int ans = func(index, arr, buy,dp);
        System.out.println(ans);
    }

    public static int func(int index, int[] arr, int buy,int dp[][]){
        if(index >= arr.length){ // no profit after complete array
            return 0;
        }

        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;

        // BUY state
        if(buy == 1){

            int take = -arr[index] + func(index+1, arr, 0,dp);


            int notTake = func(index+1, arr, 1,dp);

            profit = Math.max(take, notTake);

        } else {

                                         // after sell from next to next day you can buy
            int sell = arr[index] + func(index+2, arr, 1,dp);


            int notSell = func(index+1, arr, 0,dp);

            profit = Math.max(sell, notSell);
        }

        return dp[index][buy] = profit;
    }
}
