public class LongestDecreasingSubsequence {
    // 
    // Variation 1 : L to R (Move from left to right and check increment,  you will get LDS)
    public int lengthOfLDS(int[] nums) {
        int maxL = 0;
        int dp[] = new int[nums.length];
        for(int idx=0; idx<nums.length; idx++){
            int maxLen = 1;
            for(int i=idx-1; i>=0; i--){
                if(nums[i] > nums[idx]){
                    int tans = dp[i] + 1;
                    maxLen = Math.max(maxLen, tans);   
                }
            }

            dp[idx] = maxLen;
            maxL = Math.max(maxL, dp[idx]);
        }
        return maxL;
    }
    // Variation 2 : R to L (Move from right to left and run LIS,  you will get LDS)
    public int lengthOfLDS_2(int[] nums) {
        int maxL = 0, n = nums.length;
        int dp[] = new int[nums.length];
        for(int idx=n-1; idx>=0; idx--){
            int maxLen = 1;
            for(int i=idx+1; i<n; i++){
                if(nums[i] < nums[idx]){
                    int tans = dp[i] + 1;
                    maxLen = Math.max(maxLen, tans);   
                }
            }

            dp[idx] = maxLen;
            maxL = Math.max(maxL, dp[idx]);
        }
        return maxL;
    }

    // IMPORTANT there is a slight  difference between them, one is start of LDS and the other end of LDS
    // This becomes much more cleared in Bitonic sequence question. Watch lecture @ 01:30 
    
}
