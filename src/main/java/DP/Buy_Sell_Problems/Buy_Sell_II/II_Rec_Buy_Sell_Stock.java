package DP.Buy_Sell_Problems.Buy_Sell_II;

public class II_Rec_Buy_Sell_Stock {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int ans = func(0, arr, 1);
        System.out.println(ans);
    }

    public static int func(int index, int[] arr, int buy){
        if(index == arr.length){
            return 0;
        }

        int profit = 0;

        // BUY state
        if(buy == 1){
            // Option 1: Buy today → pay -arr[index], next we must SELL (buy=0)
            int take = -arr[index] + func(index+1, arr, 0);

            // Option 2: Skip today
            int notTake = func(index+1, arr, 1);

            profit = Math.max(take, notTake);

        } else {
            // SELL state
            // Option 1: Sell today → gain +arr[index], next we go to BUY state
            int sell = arr[index] + func(index+1, arr, 1);

            // Option 2: Skip selling
            int notSell = func(index+1, arr, 0);

            profit = Math.max(sell, notSell);
        }

        return profit;
    }
}
