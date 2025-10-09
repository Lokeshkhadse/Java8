package DP.Cherry_Pickup_2;

import java.util.Arrays;

public class Memo_Cherry_Pickup_2 {
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        int ans = cherryPickup(grid);
        System.out.println(ans);

    }
    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for(int[][] row:dp){
            for(int[] col:row){
                Arrays.fill(col,-1);
            }
        }
                        //i ,j1 ,j2 --> i is same for both robot but j is diff so that's why take two j
        int ans = func(0,0,n-1,m,n,grid,dp);
        return ans;

    }

    public static int func(int i,int j1,int j2,int m,int n,int[][] grid,int[][][] dp){
        if(j1<0 || j1 >= n || j2 < 0 || j2>= n){ //out of inex checking
            return (int) -1e9;
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        if(i == m-1){
            if(j1 == j2) return grid[i][j1];  //same cell arrived both take point only one robo
            else return grid[i][j1] + grid[i][j2];  //if not same cell then add two cell
        }

        int maxi = (int) -1e9;
        for(int robo1 = -1 ; robo1 <= 1;robo1++){ //for every robo1 moves
            for(int robo2 = -1 ; robo2 <= 1;robo2++){ // robo2 moves 3 times (3*3) = 9

                if(j1 == j2) {
                    maxi = Math.max(maxi,grid[i][j1] + func(i+1,j1+robo1,j2+robo2,m,n,grid,dp));
                }else{
                    maxi = Math.max(maxi,grid[i][j1] + grid[i][j2] + func(i+1,j1+robo1,j2+robo2,m,n,grid,dp));
                }
            }
        }
        dp[i][j1][j2] = maxi;
        return maxi;
    }
}
