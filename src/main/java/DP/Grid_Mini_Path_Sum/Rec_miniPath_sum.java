package DP.Grid_Mini_Path_Sum;

public class Rec_miniPath_sum {
    public static void main(String[] args) {
        int[][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        int answer = minPathSum(grid);
        System.out.println(answer);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = func(0,0,m,n,grid);
        return ans;
    }
    public static int func(int i, int j , int m , int n ,int[][] grid){


        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        // Base case: out of bounds
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        int right =  func(i, j + 1, m, n, grid);
        int down =  func(i + 1, j, m, n, grid);

        // ✅ Avoid overflow
        int minRight = (right == Integer.MAX_VALUE) ? Integer.MAX_VALUE : grid[i][j] + right;
        int minDown = (down == Integer.MAX_VALUE) ? Integer.MAX_VALUE : grid[i][j] + down;

        return Math.min(minRight, minDown);

    }

    //or

//    public static int func(int i, int j , int m , int n ,int[][] grid){
//
//
//        if (i == m - 1 && j == n - 1) {
//            return grid[i][j];
//        }
//
//        // Base case: out of bounds
//        if (i >= m || j >= n) return Integer.MAX_VALUE;
//
//        int right =  grid[i][j] + func(i, j + 1, m, n, grid);
//        int down =  grid[i][j]  + func(i + 1, j, m, n, grid);
//
//
//
//        return Math.min(right, down);
//
//    }
}
