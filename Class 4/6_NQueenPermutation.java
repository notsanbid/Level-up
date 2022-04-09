class NQueenPermutation {
    public static boolean isSafe(boolean[][] boxes, int r, int c){
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        int n = boxes.length;
        for(int d=0; d<dir.length; d++){
            for(int rad=0; rad<n; rad++){
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];
                if(x >= 0 && y >= 0 && x < n && y < n){
                    if(boxes[x][y]) return false;
                }
                else 
                    break;
            }
        }
        return true;
    }
    public static int nqueen(boolean[][] boxes, int tnq, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = 0; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if(isSafe(boxes, r, c)){
                boxes[r][c] = true;
                count += nqueen(boxes, tnq - 1, psf + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        boolean[][] boxes = new boolean[4][4];
        System.out.println(nqueen(boxes, 4, ""));
    }
}
