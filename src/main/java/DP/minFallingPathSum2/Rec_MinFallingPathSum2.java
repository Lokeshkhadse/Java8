//Given an n x n integer matrix grid,
//return the minimum sum of a falling path with non-zero shifts.
//
//A falling path with non-zero shifts is a choice of exactly one element from each row of grid
//such that no two elements chosen in adjacent rows are in the same column.
//
//
//
//Example 1:
//
//
//Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
//Output: 13
//Explanation:
//The possible falling paths are:
//        [1,5,9], [1,5,7], [1,6,7], [1,6,8],
//        [2,4,8], [2,4,9], [2,6,7], [2,6,8],
//        [3,4,8], [3,4,9], [3,5,7], [3,5,9]
//The falling path with the smallest sum is [1,5,7], so the answer is 13.



package DP.minFallingPathSum2;

public class Rec_MinFallingPathSum2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {-73, 61, 43, -48, -36},
                {3, 30, 27, 57, 10},
                {96, -76, 84, 59, -15},
                {5, -49, 76, 31, -7},
                {97, 91, 61, -46, 67}
        };

        int answer = minFallingPathSum(matrix);
        System.out.println("Min Falling Path Sum  " + answer);
    }
    public static int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int min = (int) 1e9;
        for(int j = 0;j<n;j++){
            min = Math.min(min,fun(0,j,m,n,grid));
        }
        return min;

    }
    public static int fun(int i , int j , int m , int n, int[][] grid){
        if(j<0 || j >= n ) return (int)1e9;
        if(i == m-1){
            return grid[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k = 0 ;k<n;k++){
            if(k == j) continue;

            min = Math.min(min,grid[i][j] + fun(i+1,k,m,n,grid));
        }
        return min;

    }
}


