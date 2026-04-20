package DP.Parenthesis_Star_Problem;

import java.util.Arrays;


public class Memo_Parenthesis_Star_problem {
    public static void main(String[] args) {
        String s = "(*))";
        int index =0  ;
        int cnt = 0 ;
        int n = s.length();

        // 🔹 dp[index][cnt]
        int dp[][] = new int[n][n + 1];

        // 🔹 fill with -1 (not visited)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        boolean ans = isvalid(s,index,cnt,dp);
        System.out.println(ans);
    }

    private static boolean isvalid(String s,int index , int cnt,int dp[][]) {
        // ❌ invalid case
        if (cnt < 0) return false;

        // ✅ base case
        if (index == s.length()) {
            return cnt == 0;
        }

        // 🔹 DP check
        if (dp[index][cnt] != -1) {
            return dp[index][cnt] == 1;
        }

        char ch = s.charAt(index);

        boolean result;

        if (ch == '(') {
            result = isvalid(s, index + 1, cnt + 1, dp);
        }
        else if (ch == ')') {
            result = isvalid(s, index + 1, cnt - 1, dp);
        }
        else { // '*'
            result =
                    isvalid(s, index + 1, cnt + 1, dp) ||  // '('
                            isvalid(s, index + 1, cnt - 1, dp) ||  // ')'
                            isvalid(s, index + 1, cnt, dp);        // empty
        }

        // 🔹 store in DP
        dp[index][cnt] = result ? 1 : 0;

        return result;
    }
}
