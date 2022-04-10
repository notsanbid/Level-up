public class NQueenBits {
    static int row = 0, col = 0, diag = 0, adiag = 0;

    public static int nqueen_02(int n, int tnq, int bno, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int bidx = bno; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if ((row & (1 << r)) == 0 && (col & (1 << c)) == 0 && (diag & (1 << (r - c + n - 1))) == 0
                    && (adiag & (1 << (r + c))) == 0) {
                row ^= (1 << r);
                col ^= (1 << c);
                diag ^= (1 << (r - c + n - 1));
                adiag ^= (1 << (r + c));

                count += nqueen_02(n, tnq - 1, bidx + 1, psf + "(" + r + "," + c + ") ");

                row ^= (1 << r);
                col ^= (1 << c);
                diag ^= (1 << (r - c + n - 1));
                adiag ^= (1 << (r + c));
            }
        }
        return count;
    }

    public static void main(String... args) {
        int n = 4, tnq = 4;
        System.out.println(nqueen_02(n, tnq, 0, ""));
    }
}
