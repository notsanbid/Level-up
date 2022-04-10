import java.nio.channels.Pipe;

class Bits {
    // LC 136, in this array every number appears twice except one, find it
    // NOTE: Concept, a^a == 0, so xor-ing every number in this array would make it 0, except the number 
    // that repeats
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int ele : nums) {
            ans ^= ele;
        }

        return ans;

    }

    // LC 268, array consists of numbers 0 to 9, except 1 number. Array size = 9. Find that missing number
    // XOR the array with all numbers 0 to 9, the number appearing twice would cancel each other 
    // leaving behind that missing number.
    public int missingNumber(int[] nums) {
        int ans = n = nums.length, i = 0; 
        while(i < n){
            ans = ans ^ nums[i] ^ (i++);
        }
        return ans;
    }

    // LC 191 (Number of 1 bits). Use the hamming weight concept

    // Hamming weight concept says that when you take '&'' of n and n-1, resultant has 1 'on' bit less than n. Last set bit gets removed
    // So, we keep repeating this process until all 1s are gone and we ending up with 0.
    // The number of times we repeat this process gives us the initial count of 1 (Best Solution)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n - 1));
        }

        return count;
    }
    // ALT : Create a new mask every step, upto 32 (int has 4 bytes), and check if that position has 1, then increment the count (2nd best Solution)
    public int hammingWeight_2(int n) {
        int count = 0, i = 0;
        while (i < 32) {
            if ((n & (1 << i)) != 0)
                count++;
            i++;
        }

        return count;
    }
    // ALT : 'And' with 1 and check if last bit non zero, then >>> (drop) the last bit and keep repeating till number is 0
    public int hammingWeight_3(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0)
                count++;
            n >>>= 1;
        }

        return count;
    }

    // Last Set Bit : 'and' of n & -n would give last set bit of n 
    public int lastSetBit(int n){
        return (n & (-n));
    }

    // (n&(n-1)) = removes last set bit   ------   (n & -n) gives last set bit 
    // So,  n = (n&(n-1)) | (n & -n) 


    // --------------------------------------------------------------------------------------------------------
    
    // 338
    // Question : given n, return n+1 sized integer array with count of '1' of values 0 to n
    // Concept : Let, x = (n&(n-1)). If n has p set bits, x has p-1 set bits. Now x is always less than n.
    // x comes before n always. So we will be resuing this , count of :  n = count of x + 1 
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;

    }


     // 260
     // Question : Every number appears twice except 2 numbers, find those numbers
     // Example : [1,2,3,1,5,2] 
     // XOR all numbers , we are left with 3^5 (110). Now where there is '1' we can say bits were different in 3 and 5
     // Find last set bit of 3^5 using n&-n technique. Mask we get is 010. Now and-ing this mask with every value, we get either 0 or 1
     // if 0, the lets say, it belongs to set A otherwise set B. While classifying, make sure you are xoring them to its respective set
     // 3 and 5 will go to different sets, and form end values. Return those. 

     public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for(int ele : nums) xor ^= ele;
        int mask = xor & (-xor);
        
        int a = 0, b = 0;
        for(int ele : nums){
            if((ele & mask) == 0) a ^= ele;
            else b ^= ele;
        }
        
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        
    }
}
