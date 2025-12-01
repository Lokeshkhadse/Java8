package DP.Partition_DP.Boolean_Evalution_True;

public class Memo {
    static long MOD = 1000000007;
    static Long[][][] dp;  // dp[i][j][0 or 1]

    public static void main(String[] args) {

        String exp = "F|T^F";
        long ways = evaluateExp(exp);

        System.out.println("Expression : " + exp);
        System.out.println("Ways to evaluate to TRUE = " + ways);
    }

    public static long evaluateExp(String exp) {

        int n = exp.length();
        dp = new Long[n][n][2]; // 0 = false, 1 = true

        return solve(exp, 0, n - 1, true);
    }

    private static long solve(String exp, int i, int j, boolean isTrue) {

        if (i > j) return 0;

        if (i == j) {
            if (isTrue) return exp.charAt(i) == 'T' ? 1 : 0;
            else return exp.charAt(i) == 'F' ? 1 : 0;
        }

        int t = isTrue ? 1 : 0;
        if (dp[i][j][t] != null) return dp[i][j][t];   // MEMOIZATION

        long ways = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {

            char operator = exp.charAt(k);

            long leftTrue  = solve(exp, i, k - 1, true);
            long leftFalse = solve(exp, i, k - 1, false);
            long rightTrue = solve(exp, k + 1, j, true);
            long rightFalse = solve(exp, k + 1, j, false);

            if (operator == '&') {

                if (isTrue) {
                    ways = (ways + (leftTrue * rightTrue) % MOD) % MOD;
                } else {
                    ways = (ways +
                            (leftTrue * rightFalse) % MOD +
                            (leftFalse * rightTrue) % MOD +
                            (leftFalse * rightFalse) % MOD) % MOD;
                }
            }

            else if (operator == '|') {

                if (isTrue) {
                    ways = (ways +
                            (leftTrue * rightTrue) % MOD +
                            (leftTrue * rightFalse) % MOD +
                            (leftFalse * rightTrue) % MOD) % MOD;
                } else {
                    ways = (ways + (leftFalse * rightFalse) % MOD) % MOD;
                }
            }

            else if (operator == '^') {

                if (isTrue) {
                    ways = (ways +
                            (leftTrue * rightFalse) % MOD +
                            (leftFalse * rightTrue) % MOD) % MOD;

                } else {
                    ways = (ways +
                            (leftTrue * rightTrue) % MOD +
                            (leftFalse * rightFalse) % MOD) % MOD;
                }
            }
        }

        return dp[i][j][t] = ways % MOD;  // STORE IN DP
    }
}