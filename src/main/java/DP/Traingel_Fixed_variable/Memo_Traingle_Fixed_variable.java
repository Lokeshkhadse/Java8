package DP.Traingel_Fixed_variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Memo_Traingle_Fixed_variable {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle)); // Output: 11
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(0, 0, n, triangle,dp);
    }

    public static int fun(int i, int j, int len, List<List<Integer>> triangle,int[][] dp) {

        // base case:-  reached last row
        if (i == len - 1) {
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != -1) return dp[i][j];

       // go to down and diagonal
        int down = triangle.get(i).get(j) + fun(i + 1, j, len, triangle,dp);
        int diagonal = triangle.get(i).get(j) + fun(i + 1, j + 1, len, triangle,dp);

      //minimum returning
        return dp[i][j] = Math.min(down, diagonal);
    }
}
