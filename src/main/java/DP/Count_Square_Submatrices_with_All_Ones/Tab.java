package DP.Count_Square_Submatrices_with_All_Ones;

import java.util.Arrays;

public class Tab {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        int result = countSquares(matrix);
        System.out.println("Total square submatrices with all 1s = " + result);
    }

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int total = 0;

        // fill dp table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // first row or column
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j],
                                Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                }

                total += dp[i][j];  // add squares ending at (i, j)
            }
        }

        // Print DP matrix for understanding
        System.out.println("DP Matrix:");
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return total;
    }
}
