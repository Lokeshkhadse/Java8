package Stack_Queue.Maximal_Ones_Rectangle;

public class Without_Stack_Using_PrefixSum {

    public static int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;

        int[][] prefixsum = new int[n][m];

        // Build height matrix (industry approach)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int number = matrix[i][j] - '0';

                if (number == 0) {
                    prefixsum[i][j] = 0;
                } else {             //for 0th row if number == 1 then put 1
                    prefixsum[i][j] = (i == 0) ? 1 : prefixsum[i - 1][j] + 1;
                }
            }
        }

        // Brute force largest rectangle for each row
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangle(prefixsum[i]));
        }

        return maxArea;
    }

    // Brute force histogram
    private static int largestRectangle(int[] heights) {

        int n = heights.length;
        int max = 0;

        for (int i = 0; i < n; i++) {

            int left = i, right = i;

            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
                left--;
            }

            while (right + 1 < n && heights[right + 1] >= heights[i]) {
                right++;
            }

            int width = right - left + 1;
            max = Math.max(max, heights[i] * width);
        }
        return max;
    }

    // Test
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1'},
                {'1','1','1'},
                {'1','1','1'}
        };

        System.out.println(maximalRectangle(matrix)); // Output: 6
    }
}
