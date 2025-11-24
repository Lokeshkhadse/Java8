package DP.Longest_String_Chain.Length;

import java.util.Arrays;
import java.util.Comparator;

public class Memo_Longest_String_Chain {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        int ans = longestStrChain(words);
        System.out.println("longest String chain length is -> " + ans);
    }
    public static int longestStrChain(String[] words) {
        int n = words.length;
        int index = 0 ;
        int prevIndex = -1;

        int dp[][] = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        String[] arr = Arrays.stream(words)
                .sorted(Comparator.comparingInt(s -> s.length()))
                .toArray(String[]::new);

        int ans = func(index,prevIndex,arr,dp);
        return ans;

    }
    public static int func(int index,int prevIndex,String[] words,int[][] dp){
        if(index == words.length){
            return 0;
        }
        if(dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];

        //not take
        int nottake =0 + func(index+1,prevIndex,words,dp);

        //take
        int take= Integer.MIN_VALUE;
        if(prevIndex == -1 || checkIsIncreasing(words[prevIndex],words[index])){
            take = 1 + func(index+1,index,words,dp);
        }

        return dp[index][prevIndex+1] = Math.max(nottake,take);
    }

    public static boolean checkIsIncreasing(String a , String b){
        if(b.length() != a.length()+1) return false;

        int i = 0 ,j = 0;
        int skip = 0;

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else{
                skip++;
                j++;
                if(skip > 1) return false;
            }
        }
        return skip <= 1;
    }
}
