package DP.UniquePaths;

public class Rec_Grid_uniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2)); // 2

    }
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];     // Just for dimensions
        boolean[][] visited = new boolean[m][n];

        return fun(0, 0, matrix, visited, m, n);
    }

    public static int fun(int i, int j, int[][] matrix, boolean[][] visited, int m, int n) {
        // Base case 1: Reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Base case 2: Out of bounds
        if (i >= m || j >= n) return 0;

        visited[i][j] = true;

        int right = 0, down = 0;

        // Move Right
        if (isSafe(i, j + 1, matrix, visited, m, n)) {
            right = fun(i, j + 1, matrix, visited, m, n);
        }

        // Move Down
        if (isSafe(i + 1, j, matrix, visited, m, n)) {
            down = fun(i + 1, j, matrix, visited, m, n);
        }

        visited[i][j] = false;

        return right + down;
    }

    public static boolean isSafe(int i, int j, int[][] matrix, boolean[][] visited, int m, int n) {
        return (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]);
    }
}
