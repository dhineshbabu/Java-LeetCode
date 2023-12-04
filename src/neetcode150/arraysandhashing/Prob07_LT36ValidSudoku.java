package neetcode150.arraysandhashing;

import java.util.*;

public class Prob07_LT36ValidSudoku {
    /*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    we can maintain a string in hashset each the row, column and block

     */

    public static boolean isValidSudoku(char[][] board) {
        // create a hashset to store the strings
        Set<String> seen = new HashSet<>();
        // loop through the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char number = board[i][j];

                // check if the number is present
                if(number != '.') {
                    // check the conditions - add will return false if element is already available in the set
                    if(!seen.add(number+" in row "+ i) ||
                        !seen.add(number+" in column "+j) ||
                        !seen.add(number+" in block "+i/3 + "-"+j/3) ) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));

    }
}
