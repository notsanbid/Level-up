public class LongestBitonicSequence {
    // GFG : https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1/
    public int LDS(int[] nums, int dp[]) {
        int maxL = 0, n = nums.length;
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
    public int LIS(int[] nums, int dp[]) {
        int maxL = 0;
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
    public int longestBitonicSequence(int[] nums)
    {
        int dpLIS[] = new int[nums.length];
        int dpLDS[] = new int[nums.length];
        LIS(nums, dpLIS);
        LDS(nums, dpLDS);
        
        int lbs = 0;
        for(int i=0; i<nums.length; i++){
            lbs = Math.max(lbs, dpLIS[i] + dpLDS[i] -1);
        }
        return lbs;
    }
}
