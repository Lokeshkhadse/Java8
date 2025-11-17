package DP.Buy_Sell_Problems.Cooldown_Buy_Sell_UnlimitedTransaction;


//after sell next day you won't buy after next to next day you can buy;

public class Rec_Cooldown_Buy_Sell_UnlimitedTransaction {
    public static void main(String[] args) {
        int arr[] = {1,2,3,0,2};
        int buy = 1;
        int index = 0 ;

        int ans = func(index, arr, buy);
        System.out.println(ans);
    }

    public static int func(int index, int[] arr, int buy){
        if(index >= arr.length){ // no profit after complete array
            return 0;
        }

        int profit = 0;

        // BUY state
        if(buy == 1){

            int take = -arr[index] + func(index+1, arr, 0);


            int notTake = func(index+1, arr, 1);

            profit = Math.max(take, notTake);

        } else {

                                         // after sell from next to next day you can buy
            int sell = arr[index] + func(index+2, arr, 1);


            int notSell = func(index+1, arr, 0);

            profit = Math.max(sell, notSell);
        }

        return profit;
    }
}
