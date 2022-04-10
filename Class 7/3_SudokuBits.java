class SudokuBits {
    // Flattening 2D to 1D, and 3D to 2D as we no longer need boolean array and we store data in integer itself.
    int[] row = new int[10];
    int[] col = new int[10];
    int[][] mat = new int[3][3];

    public boolean solveSudoku_bits(char[][] board, ArrayList<Integer> list, int idx) {
        if (idx == list.size())
            return true;

        int r = list.get(idx) / 9;
        int c = list.get(idx) % 9;

        for (int num = 1; num <= 9; num++) {
            int mask = 1 << num;
            if ((row[r] & mask) == 0 && (col[c] & mask) == 0 && (mat[r / 3][c / 3] & mask) == 0) {
                board[r][c] = (char) ('0' + num);
                row[r] ^= mask;
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;

                if (solveSudoku_bits(board, list, idx + 1))
                    return true;

                board[r][c] = '.';

                row[r] ^= mask;
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;

            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Integer> list = new ArrayList<>(); // blank places
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    list.add(i * n + j);
                } else {
                    int num = board[i][j] - '0';
                    int mask = 1 << num;
                    row[i] ^= mask;
                    col[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                }
            }
        }

        solveSudoku_bits(board, list, 0);
    }
}
