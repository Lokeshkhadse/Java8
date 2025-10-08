package DP.Traingel_Fixed_variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rec_Traingle_Fixed_variable {
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
        return fun(0, 0, n, triangle);
    }

    public static int fun(int i, int j, int len, List<List<Integer>> triangle) {

        // base case:-  reached last row
        if (i == len - 1) {
            return triangle.get(i).get(j);
        }

        // go to down and diagonal
        int down = triangle.get(i).get(j) + fun(i + 1, j, len, triangle);
        int diagonal = triangle.get(i).get(j) + fun(i + 1, j + 1, len, triangle);

        //minimum returning
        return Math.min(down, diagonal);
    }
}
