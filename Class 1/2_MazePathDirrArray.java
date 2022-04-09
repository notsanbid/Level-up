class MazePathDirrArray {
    public static int mazePath2(int sr, int sc, int er, int ec, int dir[][], char dirVal[],String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for(int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && c >= 0 && r <= er && c <= ec){
                count += mazePath2(r, c, er, ec, dir, dirVal, psf + dirVal[i]);
            }
        }
        return count;
    }

    public static void main(String[] args){
        int dir[][] = {{0, 1}, {1, 0}, {1, 1}};
        char dirVal[] = {'h', 'v', 'd'};
        System.out.println(mazePath2(0, 0, 2, 2,dir, dirVal, ""));
    }
}
