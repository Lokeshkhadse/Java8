package DP.Buy_Sell_Problems.Trasaction_Fee_Buy_Sell;


//transaction fees give from all profit :: totalprofit - transaction * fees

public class Rec_Transaction_Fees_UnlimitedTransaction {
    public static void main(String[] args) {
        int arr[] = {1,3,2,8,4,9};
        int fees = 2;
        int buy = 1;
        int index = 0 ;

        int ans = func(index, arr, buy,fees);
        System.out.println("Transaction_Fees_UnlimitedTransaction  -> " + ans);
    }

    public static int func(int index, int[] arr, int buy,int fees){
        if(index == arr.length){ // no profit after complete array
            return 0;
        }

        int profit = 0;

        // BUY state
        if(buy == 1){

            int take = -arr[index] + func(index+1, arr, 0,fees);


            int notTake = func(index+1, arr, 1,fees);

            profit = Math.max(take, notTake);

        } else {
                                   // after sell from total deduct fees
            int sell = arr[index] - fees + func(index+1, arr, 1,fees);


            int notSell = func(index+1, arr, 0,fees);

            profit = Math.max(sell, notSell);
        }

        return profit;
    }
}
