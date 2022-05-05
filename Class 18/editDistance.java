public class editDistance {
    //https://leetcode.com/problems/edit-distance/
    public int minDistance_memo(String s1, String s2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return dp[n][m] = n == 0 ? m : n;
        }
        
        if(dp[n][m] != -1) return dp[n][m]; 
        
        int a = minDistance_memo(s1, s2, n-1, m-1, dp); //replace / both chars are same
        int b = minDistance_memo(s1, s2, n, m-1, dp); //inseert
        int c = minDistance_memo(s1, s2, n-1, m, dp); //delete
        
        if(s1.charAt(n-1) == s2.charAt(m-1))
            return dp[n][m] = a;
        else 
            return dp[n][m] = Math.min(a, Math.min(b,c))+1;
        
    }
    public int minDistance_tabu(String s1, String s2, int N, int M, int dp[][]){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = n == 0 ? m : n;
                    continue;
                }

                if(s1.charAt(n-1) == s2.charAt(m-1))
                    dp[n][m] = dp[n-1][m-1];
                else 
                    dp[n][m] = Math.min(dp[n-1][m-1], Math.min(dp[n-1][m], dp[n][m-1]))+1;
            }
        }
        return dp[N][M];
    }
    public int minDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        int ans = minDistance_tabu(s1, s2, n, m, dp);       
        return ans;

        // Variation 🚀🚀
        // int[] cost = { 2, 5, 3 }; // insert, delete, replace
        // if cost is associated with each operation, find min cost. 
        // I think only this line will get tweaked
        // dp[n][m] = Math.min(dp[n-1][m-1] + cost[2], Math.min(dp[n-1][m] + cost[1], dp[n][m-1]+cost[0]));
    }
}
