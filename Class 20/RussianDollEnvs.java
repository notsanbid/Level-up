public class RussianDollEnvs {
    // LC : https://leetcode.com/problems/russian-doll-envelopes/
    // Non optimal Solution :
    // Sort the 2D array on the basis of height/ width
    // Then run LIS
    // This is non optimal 👇
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        
        int n = envelopes.length, dp[] = new int[n], max = 0;;
        for(int i=0; i<n; i++){
            int tans = 1;
            for(int j=i-1; j>=0; j--){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    tans = Math.max(tans, dp[j] + 1);
                }
            }
            dp[i] = tans;
            max = Math.max(max, tans);
        }
        return max;
    }
}
