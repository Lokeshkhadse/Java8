package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Rat_In_Maze {

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println(ratInMaze(maze));
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans; // no path possible
        }

        boolean[][] visited = new boolean[n][n];
        findPaths(0, 0, maze, ans, visited, "");
        Collections.sort(ans); // sort lexicographically
        return ans;
    }

    public static void findPaths(int i, int j, int[][] maze,
                                 ArrayList<String> ans, boolean[][] visited, String path) {
        int n = maze.length;

        // reached destination
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        visited[i][j] = true;

        // Down
        if (isSafe(maze, i + 1, j, visited)) {
            findPaths(i + 1, j, maze, ans, visited, path + "D");
        }

        // Left
        if (isSafe(maze, i, j - 1, visited)) {
            findPaths(i, j - 1, maze, ans, visited, path + "L");
        }

        // Right
        if (isSafe(maze, i, j + 1, visited)) {
            findPaths(i, j + 1, maze, ans, visited, path + "R");
        }

        // Up
        if (isSafe(maze, i - 1, j, visited)) {
            findPaths(i - 1, j, maze, ans, visited, path + "U");
        }

        visited[i][j] = false; // backtrack
    }

    public static boolean isSafe(int[][] maze, int i, int j, boolean[][] visited) {
        int n = maze.length;
        return (i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}
