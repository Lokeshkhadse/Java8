package DP.Partition_DP.Boolean_Evalution_True;

public class Rec2 {
    static long MOD = 1000000007;

    public static void main(String[] args) {

        String exp = "F|T^F";   // SAMPLE EXAMPLE
        long ways = evaluateExp(exp);

        System.out.println("Expression : " + exp);
        System.out.println("Ways to evaluate to TRUE = " + ways);
    }
    public static long evaluateExp(String exp) {
        return solve(exp, 0, exp.length() - 1, true);
    }

    private static long solve(String exp, int i, int j, boolean isTrue) {

        if (i > j) return 0;

        if (i == j) {
            if (isTrue) return exp.charAt(i) == 'T' ? 1 : 0;
            else return exp.charAt(i) == 'F' ? 1 : 0;
        }

        long ways = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {

            char operator = exp.charAt(k);

            long leftTrue = solve(exp, i, k - 1, true);
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

        return ways % MOD;
    }
}
