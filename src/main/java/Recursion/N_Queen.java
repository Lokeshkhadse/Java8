package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queen {
    public static void main(String[] args) {
        int n =  4;
        List<List<String>> res =  solveNQueens(n);
        System.out.println(res);


    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

//        for(int i = 0  ;i<n;i++){
//            Arrays.fill(board[i],'.');
//        }
        for(int i = 0  ;i<n;i++){
            for(int j = 0;j<board[i].length;j++){
                board[i][j] = '.';
            }
        }

        backtrack(0,res,board,n);
        return res;
    }

    public static void backtrack(int col,List<List<String>>res , char[][] board,int n){

        if(col == n){
            res.add(construct(board));
            return ;
        }
        for(int row = 0 ; row < n;row++){
            if( isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                backtrack(col+1,res,board,n);

                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row,int col , char[][] board , int n){

        int r, c;

        // upward cross check (top-left diagonal)
        r = row; c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--; c--;
        }

        // straight left (same row)
        c = col;
        while (c >= 0) {
            if (board[row][c] == 'Q') return false;
            c--;
        }

        // downward cross check (bottom-left diagonal)
        r = row; c = col;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r++; c--;
        }

        return true;

    }

    public static List<String> construct(char[][] board){
        List<String> path = new ArrayList<>();

        for(int i  = 0 ; i<board.length;i++){
            path.add(new String(board[i]));
        }
        return path;

    }
}
