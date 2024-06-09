package Arrays_Hashing;

import java.util.HashMap;

/**
 Determine if a 9 x 9 Sudoku board is valid.
  Only the filled cells need to be validated according to the following rules:
  Each row must contain the digits 1-9 without repetition.
  Each column must contain the digits 1-9 without repetition.
  Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 Note:
 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
*/


 public class N_36 {
     static HashMap<Character, Boolean> valid;
     public static boolean isValidSudoku(char[][] board) {
         // check about (row & col)'s valid
         for(int r=0,c=0;r<board.length;r++,c++){
             if(!Rowcheck(board,r)){
                 return false;
             }
             if(!Colcheck(board,c)){
                 return false;
             }
         }
         // check sub-Box
         for(int r=0;r<board.length;r+=3){
             for(int c=0;c<board[0].length;c+=3){
                 if(!Boxcheck(board, r,c)) return false;
             }
         }
         return true;
     }
     public static boolean HandleValid(char c, HashMap<Character, Boolean> valid){
         if(!valid.getOrDefault(c,false)){
             valid.put(c,true);
             return false;
         }
         return  true;
     }
     public static boolean Rowcheck(char[][] board, int row){
         valid = new HashMap<>();
         for(char c: board[row]){
             if(c =='.') continue;
             if(HandleValid(c, valid)){
                 return false;
             }
         }
         return true;
     }
    public static boolean Colcheck(char[][] board, int col){
        valid = new HashMap<>();
        for(int r=0;r<board.length;r++){
            if(board[r][col]=='.') continue;
            if(HandleValid(board[r][col], valid)){
                return false;
            }
        }
        return true;
    }

    public static boolean Boxcheck(char[][] board, int row, int col){
        valid= new HashMap<>();
        for(int r=row;r<row+3;r++){
            for(int c=col;c<col+3;c++){
                if(board[r][c]=='.') continue;
                if(HandleValid(board[r][c],valid)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
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
        System.out.println(isValidSudoku(board));
    }
}
