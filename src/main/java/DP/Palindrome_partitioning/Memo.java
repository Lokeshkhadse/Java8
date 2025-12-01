package DP.Palindrome_partitioning;


import java.util.Arrays;

public class Memo {
    public static void main(String[] args) {
        String s = "abaa";
        int n = s.length();

        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        int parts = function(0,s,n,dp);
        int minCuts = parts - 1;

        System.out.println(minCuts);
    }


    public static int function(int index , String s,int n,int dp[]){
        if(index == n){
            return 0;
        }
        if(dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;

        for(int i = index;i < s.length();i++){
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){

               int cut = 1 +  function(i+1,s,n,dp);

               min = Math.min(min,cut);
            }
        }
        return dp[index] = min;
    }

  public static boolean isPalindrome(String sub){
        boolean res = false;

        res = new StringBuilder(sub).reverse().toString().equals(sub);

        return res;
  }
}
