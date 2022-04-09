class bits {
    public static int leftShift(int x) {
        return x << 2;
    }

    public static int rightShift(int x) {
        return x >> 2;
    }

    public static int setTrue(int x, int idx) {
        int mask = 1 << idx;
        return x | mask;
    }

    public static int setFalse(int x, int idx) {
        int mask = ~(1 << idx);
        return x & mask;
    }

    public static boolean isEven(int x) {
        // Check if last bit is 0. Then even else odd
        // To check, 'and' with 1, if resultant is 0, them even else odd
        return (x & 1) == 0;
    }

    public static int multiplyBy2(int num, int pow) {
        // find val of : num*2^x , here x is pow
        return (num << pow);
    }

    public static int divideBy2(int num, int pow) {
        return (num >> pow);
    }

    // Leetcode : 231
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Leetcode : 342
    public boolean isPowerOfFour(int n) {
        if(!isPowerOfTwo(n)) return false;
        
        if(n == 1) return true;
        
        while(n != 0){
            n = n >>> 2;
            if(n == 1) return true;
        }
        // Note - Concept is powerOf4 has even number of 0s and one '1'. So, while n doesn't get 0, we should get n == 1 till we keep removing 2 bits each time
        return false;
    }
    // is Power of 4, counting bits technique
    public boolean isPowerOfFour_2(int n) {
        if (!isPowerOfTwo(n))
            return false;
        int count = 0;
        // Note - here we are checking if last bit is 0, if yes then increment count. And then remove the bit. 
        // Finally, if count of 0s is even, then it is power of four.
        while (n != 0) {
            if ((n & 1) == 0)
                count++;
            n >>>= 1; // only for java, cpp N >>=1;
        }
        return (count & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
