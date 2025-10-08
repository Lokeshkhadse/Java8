package DP.minFallingPathSum_right_down_left;

import java.util.Arrays;

public class Memo_minFallingPathSum {
    public static void main(String[] args) {
        int[][]  matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int answer = minFallingPathSum(matrix);
        System.out.println("minFallingPathSum IS -> " + answer);
    }

    public static int minFallingPathSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int min  = Integer.MAX_VALUE;

        //TRY ALL INDEX of 0th row (i -> stable) (j -> moving)
        for(int j = 0 ; j<n;j++){
            min = Math.min(min,fun(0,j,m,n,matrix,dp));
        }
        return min;
    }

    public static int fun(int i , int j , int m , int n , int[][] matrix,int[][] dp){

        if(j < 0 || j>=n) return (int) 1e9;  // HERE J is moving it is cheking down ,right,left
        // i is stable so we are checking j out of boound

        if(i == m-1){  // check i here because we want to go to last row (any element from last row)
            return matrix[i][j];
        }

        if(dp[i][j] != -1 )return dp[i][j];

        int down = matrix[i][j] + fun(i+1,j,m,n,matrix,dp);
        int leftDiagonal = matrix[i][j] + fun(i + 1, j - 1, m, n, matrix,dp);
        int rightDiagonal = matrix[i][j] + fun(i+1,j+1,m,n,matrix,dp);

        return dp[i][j] = Math.min(down,Math.min(leftDiagonal,rightDiagonal));
    }
}
