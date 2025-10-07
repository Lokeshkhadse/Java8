package DP.uniquePathsWithObstacles;

import java.util.Arrays;

public class Memo_uniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        boolean[][] visited = new boolean[m][n];
        int dp[][] = new int[m][n];

        for(int[] row:dp) {
            Arrays.fill(row, -1);
        }

        return fun(0, 0, obstacleGrid, visited, m, n,dp);
    }

    public static int fun(int i, int j, int[][] obstacleGrid, boolean[][] visited, int m, int n,int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if(obstacleGrid[i][j] == 1) return 0;

        // Base case 2: Out of bounds
        if (i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        visited[i][j] = true;

        int right = 0, down = 0;

        // Move Right
        if (isSafe(i, j + 1, obstacleGrid, visited, m, n)) {
            right = fun(i, j + 1, obstacleGrid, visited, m, n,dp);
        }

        // Move Down
        if (isSafe(i + 1, j, obstacleGrid, visited, m, n)) {
            down = fun(i + 1, j, obstacleGrid, visited, m, n,dp);
        }

        visited[i][j] = false;
        dp[i][j] = right + down;

        return dp[i][j];
    }

    public static boolean isSafe(int i, int j, int[][] obstacleGrid, boolean[][] visited, int m, int n) {
        return (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]);
    }
}

