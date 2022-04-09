class FFShortestPath {
    public static class pairSP {
        int len = (int) 1e9; // NOTE - Buffer
        String str = "";
    }

    public static pairSP shortesPath(int sr, int sc, int er, int ec, int[][] mat, int[][] dir, String[] dirS) {
        if(sr == er && sc == ec){
            pairSP base = new pairSP();
            base.len = 0;
            return base;
        }
        pairSP ans = new pairSP();
        mat[sr][sc] = 1; // block
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= sc && mat[r][c] == 0) {
                pairSP recAns = shortesPath(r, c, er, ec, mat, dir, dirS);
                if (recAns.len != (int)1e9 &&  recAns.len + 1 < ans.len) { // Note - recAns.len != (int)1e9 prevents the ans from loading if no path exists b/w src and dest (both buffer and achievement)
                    ans.len = recAns.len + 1;
                    ans.str = recAns.str + dirS[d];
                }
            }
        }

        mat[sr][sc] = 0; // unblock
        return ans;
    }


    public static void main(String[] args){
        // int dir[][] = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        // String dirVal[] = {"E", "SE", "S", "SW", "W", "NW", "N", "NE"};
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        String dirVal[] = {"Left", "Down", "Right", "Up"};
        int mat[][] = new int[4][4];
        mat[1][0] = 1; //obstacle
        mat[2][1] = 1; //obstacle

        pairSP base = shortesPath(0, 0, 3, 3,mat,dir, dirVal);
        System.out.println(base.len);
        System.out.println(base.str);
    }
}
