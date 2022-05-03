public class maxGoldMine {
    // https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1/

    public static int goldmine_memo(int sr, int sc, int er, int ec, int[][] arr, int[][] dp, int[][] dir) {
        if (sc == ec) {
            return dp[sr][sc] = arr[sr][sc];
        }

        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        int maxCoin = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0], c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                maxCoin = Math.max(maxCoin, goldmine_memo(r, c, er, ec, arr, dp, dir) + arr[sr][sc]);
            }
        }

        return dp[sr][sc] = maxCoin;
    }

    public static int maxGold(int n, int m, int[][] arr) {
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        int maxCoin = 0;
        for (int r = 0; r < arr.length; r++) {
            maxCoin = Math.max(maxCoin, goldmine_memo(r, 0, n - 1, m - 1, arr, dp, dir));
        }

        return maxCoin;
    }
}
