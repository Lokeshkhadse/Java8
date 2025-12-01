package DP.Palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;


public class rec {
    public static void main(String[] args) {
        String s = "abaa";
        int n = s.length();
        int parts = function(0,s,n);
        int minCuts = parts - 1;

        System.out.println(minCuts);
    }


    public static int function(int index , String s,int n){
        if(index == n){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int i = index;i < s.length();i++){
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){

               int cut = 1 +  function(i+1,s,n);

               min = Math.min(min,cut);
            }
        }
        return min;
    }

  public static boolean isPalindrome(String sub){
        boolean res = false;

        res = new StringBuilder(sub).reverse().toString().equals(sub);

        return res;
  }
}
