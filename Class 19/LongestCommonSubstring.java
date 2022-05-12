public class LongestCommonSubstring {
    // https://www.geeksforgeeks.org/longest-common-substring-dp-29/
    // Sir's 😅
    public int longestCommonSubstring(String s) {
        int n = s.length(), len = 0, stIdx = 0, count = 0;
        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0)
                    dp[i][j] = 1;
                else if (gap == 1 && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2;
                else
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0 ? dp[i + 1][j - 1] + 2 : 0;

                if (dp[i][j] > len) {
                    len = dp[i][j];
                    stIdx = i;
                }

                count += dp[i][j] > 0 ? 1 : 0;
            }
        }

        // s.substring(stIdx, stIdx + len);
        return len;
    }

    // Mine 😍 [Better]

    public int longestCommonSubstr(String S1, String S2, int n, int m){
        int len = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = S1.charAt(i) == S2.charAt(j) ?  1 : 0;
                }
                else{
                    dp[i][j] = S1.charAt(i) == S2.charAt(j) ? dp[i - 1][j - 1] + 1 : 0;
                }
                
                if(dp[i][j] > len) len = dp[i][j];
            }
        }
        return len;
    }
}
