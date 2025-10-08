package DP.minFallingPathSum_right_down_left;

public class Rec_MAXIMUM_Falling_Path {
    public static void main(String[] args) {
        int[][]  matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int answer = maxFallingPathSum(matrix);
        System.out.println("minFallingPathSum IS -> " + answer);
    }

    public static int maxFallingPathSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int max  = Integer.MIN_VALUE;

        //TRY ALL INDEX of 0th row (i -> stable) (j -> moving)
        for(int j = 0 ; j<n;j++){
            max = Math.max(max,fun(0,j,m,n,matrix));
        }
        return max;
    }

    public static int fun(int i , int j , int m , int n , int[][] matrix){

        if(j < 0 || j>=n) return (int) -1e9;  // HERE J is moving it is cheking down ,right,left
        // i is stable so we are checking j out of boound

        if(i == m-1){  // check i here because we want to go to last row (any element from last row)
            return matrix[i][j];
        }

        int down = matrix[i][j] + fun(i+1,j,m,n,matrix);
        int leftDiagonal = matrix[i][j] + fun(i + 1, j - 1, m, n, matrix);
        int rightDiagonal = matrix[i][j] + fun(i+1,j+1,m,n,matrix);

        return Math.max(down,Math.max(leftDiagonal,rightDiagonal));
    }
}


