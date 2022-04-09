class Queen2Dpermutation {
    // Sir's
    // public static int queenPermutation2D(boolean[][] boxes, int tnq, String psf) {
    //     if (tnq == 0) {
    //         System.out.println(psf);
    //         return 1;
    //     }
    //     int count = 0, n = boxes.length;
    //     for (int bidx = 0; bidx < n * n; bidx++) {
    //         int r = bidx / n, c = bidx % n;
    //         if(!boxes[r][c]){
    //             boxes[r][c] = true;
    //             count += queenCombination2D(boxes, tnq - 1, psf + "(" + r + "," + c + ") ");
    //             boxes[r][c] = false;
    //         } 
    //     }
    //     return count;
    // }
    public static int queen2D(int[][] boxes, int noq, int queenNo){
        if(queenNo == noq+1){
            // display(boxes);
            return 1;
        }
        int count = 0;
        for(int i=0; i<boxes.length*boxes[0].length; i++){
            int r = i/boxes[0].length;
            int c = i%boxes[0].length;
            if(boxes[r][c] == 0){
                boxes[r][c] = queenNo;
                count += queen2D(boxes, noq, queenNo+1);
                boxes[r][c] = 0;
            }
        }
        return count;
    }
    public static void display(int boxes[][]){
        for(int i=0; i<boxes.length; i++) {
            for(int j=0; j<boxes[0].length; j++) {
                System.out.print(boxes[i][j] + " ");
            }
            System.out.println();    
        }
        System.out.println("----------------------------------");
    }
    public static void main(String[] args) {
        int[][] boxes = new int[4][4];
        int noq = 4; // Number of queens
        System.out.println(queen2D(boxes, noq, 1)); // 1820 * 4! 


        // Sir's :
        // boolean[][] boxes = new boolean[4][4];
        // System.out.println(queenPermutation2D(boxes, 4, ""));
    }
}
