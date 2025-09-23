package Recursion;

public class Sudoko {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Sudoku before solving:");
        printBoard(board);

        if (solve(board)) {
            System.out.println("\nSudoku after solving:");
            printBoard(board);
        } else {
            System.out.println("No solution exists!");
        }
    }

    public static boolean solve(char[][] board){
        for(int i = 0 ; i<board.length;i++){
            for(int j = 0 ;j<board[i].length;j++){

                if(board[i][j] == '.'){
                    for(char c ='1'; c <= '9' ;c++){

                        if(isValidToPlace(i,j,board,c)){
                            board[i][j] = c;

                            if(solve(board) == true){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidToPlace(int row,int col,char[][] board,char c){
        for(int i = 0 ;i<9;i++){

            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }



    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
