class SudokuBoolean {
    // o(1) Checking isSafe() optimization
    boolean[][] rows = new boolean[10][10]; // NOTE : Update
    boolean[][] cols = new boolean[10][10]; // NOTE : Update
    boolean[][][] mats = new boolean[3][3][10]; // NOTE : Update

    public boolean sudokuSolver(char[][] board, ArrayList<Integer> list, int idx){
        if(idx == list.size()) return true;

        int r = list.get(idx)/9;
        int c = list.get(idx)%9;

        for(int i = 1; i <= 9; i++) {
            if(!rows[r][num] && !cols[c][num] && !mats[r / 3][c / 3][num]){     // NOTE : Update
                board[r][c] = (char)('0' + i);

                rows[r][num] = cols[c][num] = mats[r / 3][c / 3][num] = true;   // NOTE : Update

                if(sudokuSolver(board, list, idx+1)) return true;
                board[r][c] = '.';

                rows[r][num] = cols[c][num] = mats[r / 3][c / 3][num] = true;   // NOTE : Update
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Integer> list = new ArrayList<>(); 
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    list.add(i * n + j);
                } else {
                    int num = board[i][j] - '0'; // NOTE : Update
                    rows[i][num] = cols[j][num] = mats[i / 3][j / 3][num] = true; // NOTE : Update
                }
            }
        }
        sudokuSolver(board, list, 0);
    }
}
