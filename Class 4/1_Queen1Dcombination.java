// Place queens q0, q1, q2 power wise (q0>q1>q2) in 1D array in the order
class Queen1Dcombination {
    public static int queen1D(int[] boxes, int noq, int queenNo, int si){
        if(queenNo == noq+1){
            display(boxes);
            return 1;
        }
        int count = 0;
        for(int i=si; i<boxes.length; i++){
            boxes[i] = queenNo;
            count += queen1D(boxes, noq, queenNo+1, i+1);
            boxes[i] = 0;
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
        System.out.println(queen1D(boxes, noq, 1, 0)); // OP- 20
    }
}
