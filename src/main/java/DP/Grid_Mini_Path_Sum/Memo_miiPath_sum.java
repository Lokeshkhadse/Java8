package DP.Grid_Mini_Path_Sum;

import java.util.Arrays;

public class Memo_miiPath_sum {
    public static void main(String[] args) {
        int[][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        int answer = minPathSum(grid);
        System.out.println(answer);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        int ans = func(0,0,m,n,grid,dp);
        return ans;
    }
    public static int func(int i, int j , int m , int n ,int[][] grid,int[][] dp){


        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (i >= m || j >= n) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int right = func(i, j + 1, m, n, grid, dp);
        int down = func(i + 1, j, m, n, grid, dp);

        // ✅ Avoid overflow
        int minRight = (right == Integer.MAX_VALUE) ? Integer.MAX_VALUE : grid[i][j] + right;
        int minDown = (down == Integer.MAX_VALUE) ? Integer.MAX_VALUE : grid[i][j] + down;

        dp[i][j] =  Math.min(minRight, minDown);

        return dp[i][j];

    }
}
