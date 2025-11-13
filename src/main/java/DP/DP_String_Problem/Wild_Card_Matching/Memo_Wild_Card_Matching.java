package DP.DP_String_Problem.Wild_Card_Matching;

import java.util.Arrays;

public class Memo_Wild_Card_Matching {

    public static void main(String[] args) {
        String s = "abefgcd";
        String p = "ab*cd";

        int m = s.length();
        int n = p.length();

        // dp[i][j] stores result of func(s, p, i, j)
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // -1 → not calculated yet
        }

        boolean ans = func(s, p, m - 1, n - 1, dp);
        System.out.println("Match Result → " + ans);
    }

    public static boolean func(String s, String p, int i, int j, int[][] dp) {
        // Base cases
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int m = 0; m <= j; m++) {
                if (p.charAt(m) != '*') return false;
            }
            return true;
        }

        // Check memo table
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean result;

        // ✅ Case 1: match or '?'
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            result = func(s, p, i - 1, j - 1, dp);
        }

        // ✅ Case 2: '*' → two possibilities
        else if (p.charAt(j) == '*') {
            result = func(s, p, i - 1, j, dp) || func(s, p, i, j - 1, dp);
        }

        // ❌ Case 3: not match
        else {
            result = false;
        }

        // Store result in dp (1 = true, 0 = false)
        dp[i][j] = result ? 1 : 0;
        return result;
    }
}
