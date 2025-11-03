package DP.Infinite_coins_use_for_Target;
//
//Example 1:
//
//Input: amount = 5, coins = [1,2,5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//        5=5
//        5=2+2+1
//        5=2+1+1+1
//        5=1+1+1+1+1
//Example 2:
//
//Input: amount = 3, coins = [2]
//Output: 0
//Explanation: the amount of 3 cannot be made up just with coins of 2.
//Example 3:
//
//Input: amount = 10, coins = [10]
//Output: 1

public class Rec_Infinite_coins_use_for_Target {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount = 5;
        int n =  coins.length;

        int ans = function(n-1,coins,amount);
        if(ans < 1) System.out.println(0);

        System.out.println(ans);
    }
    public static int function(int index , int coins[], int target){
        if(index == 0 ){
            if(target % coins[index] == 0)  return 1;
            else return 0;
        }

        int notPick = function(index-1,coins,target);

        int pick = 0;

        if(coins[index] <= target){
            pick = function(index,coins,target-coins[index]);
        }
        return notPick + pick;
    }
}
