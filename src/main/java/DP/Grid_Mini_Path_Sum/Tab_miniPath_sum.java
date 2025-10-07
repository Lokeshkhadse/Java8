package DP.Grid_Mini_Path_Sum;

import java.util.Arrays;

public class Tab_miniPath_sum {
    public static void main(String[] args) {
        int[][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        int answer = minPathSum(grid);
        System.out.println(answer);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int row = 0 ;row < m;row++){
            for(int col = 0 ;col<n;col++){
                if(row == 0 && col ==0 ){
                    dp[0][0] = grid[row][col];
                } else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    //up
                    if(row > 0) up = grid[row][col] + dp[row-1][col];

                    //left
                    if(col > 0) left = grid[row][col] + dp[row][col-1];

                    dp[row][col] =Math.min(up,left);
                }
            }
        }
         return dp[m-1][n-1];
    }
}

