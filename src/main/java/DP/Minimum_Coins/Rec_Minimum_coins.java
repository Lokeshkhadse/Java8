package DP.Minimum_Coins;

//Example 1:
//
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Example 2:
//
//Input: coins = [2], amount = 3
//Output: -1
//Example 3:
//
//Input: coins = [1], amount = 0
//Output: 0

public class Rec_Minimum_coins {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount  = 11;

        int res = coinChange(coins,amount);
        System.out.println(res);
    }
    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int index = n-1;
        int ans = min_No_Of_Coin(index,coins,amount);
        if (ans >= (int)1e9) return -1;
        return ans;
    }
     public static int min_No_Of_Coin(int index,int[] coins,int amount){
        if(index == 0){
            if(amount % coins[index] == 0){
                return amount / coins[index];
            }else{
                return (int) 1e9;
            }
        }

        int notpick = 0 + min_No_Of_Coin(index-1,coins,amount);

        int pick = (int)1e9;
        if(coins[index] <= amount){
            pick = 1 + min_No_Of_Coin(index,coins,amount-coins[index]);
        }

        return Math.min(notpick , pick);
     }

}
