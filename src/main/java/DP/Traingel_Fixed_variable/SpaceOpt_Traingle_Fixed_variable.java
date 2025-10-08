package DP.Traingel_Fixed_variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpaceOpt_Traingle_Fixed_variable {
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
      int frontRow[] = new int[n];

        //base case
        for(int j = 0  ;j<triangle.get(n-1).size();j++){
            frontRow[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2;i>=0;i--){
            int[] currRow = new int[n];
            for(int j = 0;j<triangle.get(i).size();j++){
                int down = triangle.get(i).get(j) + frontRow[j];
                int diagonal = triangle.get(i).get(j) + frontRow[j + 1];
                currRow[j] = Math.min(down, diagonal);
            }
            frontRow = currRow;
        }
        return frontRow[0];
    }
}
