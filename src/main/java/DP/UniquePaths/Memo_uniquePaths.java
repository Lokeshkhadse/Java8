package DP.UniquePaths;

import java.util.Arrays;

public class Memo_uniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2)); // 2

    }
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];     // Just for dimensions
        boolean[][] visited = new boolean[m][n];
        int dp[][] = new int[m][n];

        for(int[] row:dp) {
            Arrays.fill(row, -1);
        }

        return fun(0, 0, matrix, visited, m, n,dp);
    }

    public static int fun(int i, int j, int[][] matrix, boolean[][] visited, int m, int n,int[][] dp) {
        // Base case 1: Reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Base case 2: Out of bounds
        if (i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        visited[i][j] = true;

        int right = 0, down = 0;

        // Move Right
        if (isSafe(i, j + 1, matrix, visited, m, n)) {
            right = fun(i, j + 1, matrix, visited, m, n,dp);
        }

        // Move Down
        if (isSafe(i + 1, j, matrix, visited, m, n)) {
            down = fun(i + 1, j, matrix, visited, m, n,dp);
        }

        visited[i][j] = false;
        dp[i][j] = right + down;

        return dp[i][j];
    }

    public static boolean isSafe(int i, int j, int[][] matrix, boolean[][] visited, int m, int n) {
        return (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]);
    }
}


