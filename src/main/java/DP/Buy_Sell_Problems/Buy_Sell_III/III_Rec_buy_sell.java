package DP.Buy_Sell_Problems.Buy_Sell_III;

public class III_Rec_buy_sell {   //only  2 transaction and max profit find out
    public static void main(String[] args) {
        int stocks[] = {3,3,5,0,0,3,1,4};
        int n = stocks.length;

        int buy = 1; // 1 means allow to buy
        int index = 0 ;
        int transaction = 2;
        int maxProfit = function(index,buy,stocks,transaction);
        System.out.println("2 transaction and max profit -> " + maxProfit);
    }
    public static int function(int index , int buy, int[] stocks, int transaction){

        //base case
        // transaction == 0 means 2 transaction complete do not go further return 0
        if(transaction == 0) return 0;

        //if(stocks exhausted means go beyond return 0
        if(index == stocks.length ) return 0;

        int profit = 0 ;

        if(buy == 1){    // allow to buy

            int  take = -stocks[index] + function(index+1,0,stocks,transaction);
            int nottake = 0 + function(index+1,1,stocks,transaction);

            profit = Math.max(take,nottake);
        }else{

            int sell = stocks[index] + function(index+1,1,stocks,transaction-1);
            int notSell = 0 + function(index+1,0,stocks,transaction);

            profit = Math.max(sell,notSell);
        }

        return profit;
    }
}
