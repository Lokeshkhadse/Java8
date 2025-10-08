package DP.Traingel_Fixed_variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tab_Traingle_Fixed_variable {
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

       //base case
        for(int j = 0  ;j<triangle.get(n-1).size();j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}

