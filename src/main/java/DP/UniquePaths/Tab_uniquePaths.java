package DP.UniquePaths;

public class Tab_uniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2)); // Output: 2
        System.out.println(uniquePaths(3, 3)); // Output: 6
        System.out.println(uniquePaths(3, 7)); // Output: 28
    }
    public static int uniquePaths(int m, int n){
        int dp[][] = new int[m][n];

        dp[0][0] = 1;   //base case

        for(int i = 0 ;i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(i == 0 && j == 0 ) continue;
                else{
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
