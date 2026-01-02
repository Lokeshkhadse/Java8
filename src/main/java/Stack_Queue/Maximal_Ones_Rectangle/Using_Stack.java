package Stack_Queue.Maximal_Ones_Rectangle;

import java.util.Stack;

public class Using_Stack {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] prefixsum = new int[n][m];

        // Step 1: Build height matrix (prefix sum)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int number = matrix[i][j] - '0';

                if (number == 0) {
                    prefixsum[i][j] = 0;
                } else {
                    prefixsum[i][j] = (i == 0) ? 1 : prefixsum[i - 1][j] + 1;
                }
            }
        }

        // Step 2: For each row, find largest rectangle in histogram
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(prefixsum[i]));
        }

        return maxArea;
    }

    // PSE + NSE approach
    private int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // PSE
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // NSE
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Max Area
        int max = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }

        return max;
    }
}
