package DP.Grid_Max_Path_Sum;

public class Tab_maxPath_sum {
    public static void main(String[] args) {
        int[][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        int answer = maxPathSum(grid);
        System.out.println(answer);
    }

    public static int maxPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int row = 0 ;row < m;row++){
            for(int col = 0 ;col<n;col++){
                if(row == 0 && col ==0 ){
                    dp[0][0] = grid[row][col];
                } else{
                    int up = Integer.MIN_VALUE;
                    int left = Integer.MIN_VALUE;
                    //up
                    if(row > 0) up = grid[row][col] + dp[row-1][col];

                    //left
                    if(col > 0) left = grid[row][col] + dp[row][col-1];

                    dp[row][col] =Math.max(up,left);
                }
            }
        }
         return dp[m-1][n-1];
    }
}

