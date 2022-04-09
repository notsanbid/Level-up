class FloodFill {
    public static int floodFill(int sr, int sc, int er, int ec, int dir[][], String dirVal[],String psf, boolean visited[][]) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }
        visited[sr][sc] = true;
        int count = 0;
        for(int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && c >= 0 && r <= er && c <= ec && !visited[r][c]) {
                count += floodFill(r, c, er, ec, dir, dirVal, psf + " " + dirVal[i], visited);
            }
        }
        visited[sr][sc] = false;
        return count;
    }

    public static void main(String[] args){
        int dir[][] = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        String dirVal[] = {"E", "SE", "S", "SW", "W", "NW", "N", "NE"};
        System.out.println(floodFill(0, 0, 3, 3,dir, dirVal, "", new boolean[4][4]));
    }
}
