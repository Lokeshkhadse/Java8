package DP.Cherry_Pickup_2;

public class Tab_Cherry_Pickup_2 {
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        int ans = cherryPickup(grid);
        System.out.println(ans);
    }

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        // Base case: last row
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2)
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                else
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
            }
        }

        // From second last row to first row
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {

                    int maxi = (int) -1e9;

                    for (int robo1 = -1; robo1 <= 1; robo1++) {
                        for (int robo2 = -1; robo2 <= 1; robo2++) {

                            int val = 0;
                            if (j1 == j2)
                                val = grid[i][j1];
                            else
                                val = grid[i][j1] + grid[i][j2];

                            int nextVal = 0;
                            if (j1 + robo1 < 0 || j1 + robo1 >= n || j2 + robo2 < 0 || j2 + robo2 >= n)
                                nextVal = (int) -1e9;
                            else
                                nextVal = dp[i + 1][j1 + robo1][j2 + robo2];

                            val += nextVal;
                            maxi = Math.max(maxi, val);
                        }
                    }

                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][n - 1];
    }
}
