package DP.uniquePathsWithObstacles;

public class Tab_uniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        int dp[][] = new int[m][n];

        dp[0][0] = 1;   //base case

        for(int i = 0 ;i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(i == 0 && j == 0 ) continue;
                else{
                    if(obstacleGrid[i][j] == 1) continue;
                    int up  = 0 ,left = 0;    //in tabulation change thinking opposite moves

                    if(i > 0) up  = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
