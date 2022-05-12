public class MazimumSumBionicSubs {
    // GFG : https://practice.geeksforgeeks.org/problems/maximum-sum-bitonic-subsequence1857/1/
    public static int LDS(int[] nums, int dp[]) {
        int maxL = 0, n = nums.length;
        for(int idx=n-1; idx>=0; idx--){
            int maxLen = nums[idx];
            for(int i=idx+1; i<n; i++){
                if(nums[i] < nums[idx]){
                    int tans = dp[i] + nums[idx];
                    maxLen = Math.max(maxLen, tans);   
                }
            }

            dp[idx] = maxLen;
            maxL = Math.max(maxL, dp[idx]);
        }
        return maxL;
    }
    public static int LIS(int[] nums, int dp[]) {
        int maxL = 0;
        for(int idx=0; idx<nums.length; idx++){
            int maxLen = nums[idx];
            for(int i=idx-1; i>=0; i--){
                if(nums[i] < nums[idx]){
                    int tans = dp[i] + nums[idx];
                    maxLen = Math.max(maxLen, tans);   
                }
            }

            dp[idx] = maxLen;
            maxL = Math.max(maxL, dp[idx]);
        }
        return maxL;
    }
    public static int maxSumBS(int nums[], int n)
    {
        int dpLIS[] = new int[nums.length];
        int dpLDS[] = new int[nums.length];
        LIS(nums, dpLIS);
        LDS(nums, dpLDS);
        
        int lbs = 0;
        for(int i=0; i<nums.length; i++){
            lbs = Math.max(lbs, dpLIS[i] + dpLDS[i] - nums[i]);
        }
        return lbs;
    }
    
}
