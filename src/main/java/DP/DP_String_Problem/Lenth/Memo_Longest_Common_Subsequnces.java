package DP.DP_String_Problem.Lenth;

import java.util.Arrays;

public class Memo_Longest_Common_Subsequnces {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";

        int index1 = s1.length();
        int index2 = s2.length();

        int[][] dp = new int[index1][index2];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int longestCommonSubsequenceLength = formSubsequence(s1,s2,index1-1,index2-1,dp);
        System.out.println("longestCommonSubsequenceLength is ->" +longestCommonSubsequenceLength);

    }

    public static int formSubsequence(String s1,String s2,int index1 , int index2,int[][] dp) {

        if(index1 < 0 || index2 < 0){
            return 0;
        }
        if(dp[index1][index2] != -1) return dp[index1][index2];

        //Match
        if(s1.charAt(index1) == s2.charAt(index2)){
            return dp[index1][index2] = 1 + formSubsequence(s1,s2,index1-1,index2-1,dp);
        }

        //not match and max return
        return dp[index1][index2] = 0 + Math.max(formSubsequence(s1,s2,index1-1,index2,dp),
                                        formSubsequence(s1,s2,index1,index2-1,dp));
    }
}
