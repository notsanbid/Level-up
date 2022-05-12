public class LongestIncreasingSubsequence {
    // LC : https://leetcode.com/problems/longest-increasing-subsequence/
    public int lengthOfLIS_memo(int[] nums, int idx, int dp[]) {
        if(dp[idx] != 0) return dp[idx];
        
        int maxL = 1;
        for(int i=idx-1; i>=0; i--){
            if(nums[i] < nums[idx]){
                int tans = lengthOfLIS_memo(nums, i, dp) + 1;
                maxL = Math.max(maxL, tans);   
            }
        }
        
        return dp[idx] = maxL;
    }
    
    public int lengthOfLIS_tabu(int[] nums) {
        int maxL = 0;
        int dp[] = new int[nums.length];
        for(int idx=0; idx<nums.length; idx++){
            int maxLen = 1;
            for(int i=idx-1; i>=0; i--){
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

    public int lengthOfLIS(int[] nums) {
        int maxL = 0;
        int dp[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            maxL = Math.max(maxL, lengthOfLIS_memo(nums, i, dp));
        }
        return maxL;
    }   
}
