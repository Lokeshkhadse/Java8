package DP.minFallingPathSum_right_down_left;

public class SpaceOpt_Memo_minFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int answer = minFallingPathSum(matrix);
        System.out.println("minFallingPathSum IS -> " + answer);
    }

    public static int minFallingPathSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[] front = new int[m];

        // Step 1: Base case — copy the first row as it is
        for (int j = 0; j < n; j++) {
            front[j] = matrix[0][j];
        }

        // Step 2: Build dp table from top (i=1) to bottom (i=m-1)
        for (int i = 1; i < m; i++) {
            int current[] = new int[m];
            for (int j = 0; j < n; j++) {

                int up = matrix[i][j] + front[j]; // from top
                int leftDiag = matrix[i][j] + (j - 1 >= 0 ? front[j - 1] : (int) 1e9);
                int rightDiag = matrix[i][j] + (j + 1 < n ? front[j + 1] : (int) 1e9);

                current[j] = Math.min(up, Math.min(leftDiag, rightDiag));
            }
            front = current;
        }

        // Step 3: find min from last row
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, front[j]);
        }

        return min;
    }
}
