package DP.Buy_Sell_Problems.Trasaction_Fee_Buy_Sell;




import java.util.Arrays;

public class Memo_Transaction_Fees_UnlimitedTrasaction {
    public static void main(String[] args) {
        int arr[] = {1,3,2,8,4,9};
        int fees = 2;
        int buy = 1;
        int index = 0 ;

        int dp[][] = new int[arr.length][2];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        int ans = func(index, arr, buy,dp,fees);
        System.out.println(ans);
    }

    public static int func(int index, int[] arr, int buy,int dp[][],int fees){
        if(index == arr.length){ // no profit after complete array
            return 0;
        }

        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;

        // BUY state
        if(buy == 1){

            int take = -arr[index] + func(index+1, arr, 0,dp,fees);


            int notTake = func(index+1, arr, 1,dp,fees);

            profit = Math.max(take, notTake);

        } else {


            int sell = arr[index] - fees + func(index+1, arr, 1,dp,fees);


            int notSell = func(index+1, arr, 0,dp,fees);

            profit = Math.max(sell, notSell);
        }

        return dp[index][buy] = profit;
    }
}
