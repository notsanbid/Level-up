class NQueenBitsPermu {
    // Just one change from combination
    static boolean[] rows, cols, diags, adiags;
    public static int nqueen_01(int n, int tnq, int bno, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int bidx = 0; bidx < n * n; bidx++) { // Change : bidx = 0; instead of bidx = bno;
            int r = bidx / n, c = bidx % n;
            if (!rows[r] && !cols[c] && !diags[r - c + n - 1] && !adiags[r + c]) {
                rows[r] = cols[c] = diags[r - c + n - 1] = adiags[r + c] = true;
                count += nqueen_01(n, tnq - 1, bidx + 1, psf + "(" + r + "," + c + ") ");
                rows[r] = cols[c] = diags[r - c + n - 1] = adiags[r + c] = false;
            }
        }
        return count;
    }
    public static void main(String... args) {
        int n = 4, tnq = 4;
        rows = new boolean[n];
        cols = new boolean[n];
        diags = new boolean[n + n - 1];
        adiags = new boolean[n + n - 1];
        System.out.println(nqueen_01(n, tnq, 0, ""));
    }
}