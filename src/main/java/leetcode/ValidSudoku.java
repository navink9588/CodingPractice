package leetcode;

/**
 * @author Navin Kumar
 * @date 7/7/18
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * Solution
 * https://www.programcreek.com/2014/05/leetcode-valid-sudoku-java/
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        if(m != 9) return false;
        int n = board[0].length;
        if(n != 9) return false;

        char dot = '.';

        // Column check
        for(int i = 0; i < m; i++) {
            boolean[] seen = new boolean[m];
            for(int j = 0; j < n; j++) {
                if(board[i][j] != dot) {
                    int val = Character.getNumericValue(board[i][j]) - 1;
                    if(seen[val]) return false;
                    seen[val] = true;
                }
            }
        }

        // Row check
        for(int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n];
            for(int i = 0; i < m; i++) {
                if(board[i][j] != dot) {
                    int val = Character.getNumericValue(board[i][j]) - 1;
                    if(seen[val]) return false;
                    seen[val] = true;
                }
            }
        }

        // Block check
        for(int i = 0; i < m; i = i + 3) {
            for(int j = 0; j < n; j = j + 3) {
                boolean block = blockCheck(board, i, j);
                if(!block) return false;
            }
        }


        return true;
    }

    private boolean blockCheck(char[][] board, int m, int n) {
        char dot = '.';
        for(int i = m; i < m + 3; i++) {
            boolean[] seen = new boolean[9];
            for(int j = n; j < n + 3; j++) {
                if(board[i][j] != dot) {
                    int val = Character.getNumericValue(board[i][j]) - 1;
                    if(seen[val]) return false;
                    seen[val] = true;
                }
            }
        }
        return true;
    }

}
