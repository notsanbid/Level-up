public class NQueenBest {
    // Restricting a queen to a single floor
    static int row = 0, col = 0, diag = 0, adiag = 0;

    public static int nqueen(int n, int floor, String psf) {
        if (floor == n) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, r = floor;
        for (int c = 0; c < n; c++) {
            if ((row & (1 << r)) == 0 && (col & (1 << c)) == 0 && (diag & (1 << (r - c + n - 1))) == 0
                    && (adiag & (1 << (r + c))) == 0) {
                row ^= (1 << r);
                col ^= (1 << c);
                diag ^= (1 << (r - c + n - 1));
                adiag ^= (1 << (r + c));

                count += nqueen(n, floor+1, psf + "(" + r + "," + c + ") ");

                row ^= (1 << r);
                col ^= (1 << c);
                diag ^= (1 << (r - c + n - 1));
                adiag ^= (1 << (r + c));
            }
        }
        return count;
    }

    public static void main(String... args) {
        int n = 4;
        System.out.println(nqueen(n, 0, ""));
    }
}
