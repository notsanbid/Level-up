class Queen1Dpermutation {
    public static int queen1D(int[] boxes, int noq, int queenNo){
        if(queenNo == noq+1){
            display(boxes);
            return 1;
        }
        int count = 0;
        for(int i=0; i<boxes.length; i++){
            if(boxes[i] == 0) {
                boxes[i] = queenNo;
                count += queen1D(boxes, noq, queenNo+1);
                boxes[i] = 0;
            }
        }
        return count;
    }
    public static void display(int boxes[]){
        for(int i=0; i<boxes.length; i++) System.out.print(boxes[i]);
        System.out.println();
    }
    public static void main(String[] args) {
        int[] boxes = new int[6];
        int noq = 3; // Number of queens
        System.out.println(queen1D(boxes, noq, 1));  // OP = 120, 20(that is no of combi) * 3!
    }
}
