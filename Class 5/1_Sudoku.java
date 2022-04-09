// 2D to 1D : idx = r*m + c;
// 1D to 2D : r = idx/m , c = idx%m
// Leetcode : 37
import java.util.*;
class Sudoku {

    private boolean isSafe(char[][] board, int idx, int r, int c){
        // row
        for (int i = 0; i < 9; i++) {
            if (board[i][c] - '0' == num)
                return false;
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (board[r][i] - '0' == num)
                return false;
        }

        // Compression and Decompression to reach starting of each block
        r = (r/3)*3;
        c = (c/3)*3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (board[r+i][c+j] - '0' == num)
                    return false;
            }
        }
        return true;
    }

    public boolean sudokuSolver(char[][] board, ArrayList<Integer> list, int idx){
        if(idx == list.size()) return true;

        int r = list.get(idx)/9;
        int c = list.get(idx)%9;

        for(int i = 1; i <= 9; i++) {
            if(isSafe(board, i, r, c)){
                board[r][c] = (char)('0' + i);
                if(sudokuSolver(board, list, idx+1)) return true; // NOTE : Important
                board[r][c] = '.';
            }
        }

        return false;
    }

    // Flattening 2D board to 1D and adding only unfilled cells to reduce not required calls
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> list = new ArrayList<>(); // blank places
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    list.add(i * n + j);
                }
            }
        }
        sudokuSolver(board, list, 0);
    }

    
}
