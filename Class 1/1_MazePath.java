class MazePath {
    public static int mazePath(int sr, int sc, int er, int ec, String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        if (sc + 1 <= ec)
            count += mazePath(sr, sc + 1, er, ec, psf + "h"); // H
        if (sr + 1 <= er)
            count += mazePath(sr + 1, sc, er, ec, psf + "v"); // V
        if (sc + 1 <= ec && sr + 1 <= er)
            count += mazePath(sr + 1, sc + 1, er, ec, psf + "d"); // D

        return count;
    }

    public static void main(String[] args){
        System.out.println(mazePath(0, 0, 2, 2, ""));
    }
}