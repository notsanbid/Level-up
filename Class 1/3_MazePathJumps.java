class MazePathJumps {
    public static int mazePathJumps(int sr, int sc, int er, int ec, int dir[][], char dirVal[],String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for(int i = 0; i < dir.length; i++) {
            // First Fix direction then dig deep
            for(int rad = 1; rad <= Math.max(er, ec); rad++){
                int r = sr + rad*dir[i][0];
                int c = sc + rad*dir[i][1];
                if(r >= 0 && c >= 0 && r <= er && c <= ec){
                    count += mazePathJumps(r, c, er, ec, dir, dirVal, psf + dirVal[i]+rad);
                } else
                    break;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int dir[][] = {{0, 1}, {1, 0}, {1, 1}};
        char dirVal[] = {'h', 'v', 'd'};
        System.out.println(mazePathJumps(0, 0, 2, 2,dir, dirVal, ""));
    }
}
