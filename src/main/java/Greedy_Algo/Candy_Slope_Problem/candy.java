package Greedy_Algo.Candy_Slope_Problem;

import java.util.Arrays;

public class candy {

    public static void main(String[] args) {

        int[] ratings = {1, 0, 2};   // -> {2,1,2} = > 5

        int n = ratings.length;

        int[] leftarr = new int[n];
        int[] rightarr = new int[n];

        int one = 1;

        // 🔹 Left to Right
        leftarr[0] = one;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftarr[i] = leftarr[i - 1] + 1;
            } else {
                leftarr[i] = one;
            }
        }

        // 🔹 Right to Left
        rightarr[n - 1] = one;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightarr[i] = rightarr[i + 1] + 1;
            } else {
                rightarr[i] = one;
            }
        }

        System.out.println("left arr is ->" + Arrays.toString(leftarr));
        System.out.println("right arr is ->" + Arrays.toString(rightarr));

        // 🔹 Final Sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(leftarr[i], rightarr[i]);
        }

        System.out.println("Minimum Candies Required = " + sum);
    }
}