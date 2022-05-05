public class mazePath {
    public static int mazePath_memo(int er, int ec, int[][] dp, int[][] dir) {
        if (er == 0 && ec == 0) {
            return dp[er][ec] = 1;
        }

        if (dp[er][ec] != 0)
            return dp[er][ec];

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = er + dir[d][0];
            int c = ec + dir[d][1];
            if (r >= 0 && c >= 0 && r < dp.length && c < dp.length) {
                count += mazePath_memo(r, c, dp, dir);
            }
        }

        return dp[er][ec] = count;
    }
    public static int mazePath_tabu(int ER, int EC, int[][] dp, int[][] dir) {
        for (int er = 0; er <= ER; er++) {
            for (int ec = 0; ec <= EC; ec++) {
                if (er == 0 && ec == 0) {
                    dp[er][ec] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = er + dir[d][0];
                    int c = ec + dir[d][1];
                    if (r >= 0 && c >= 0 && r < dp.length && c < dp.length) {
                        count += dp[r][c];
                    }
                }
                dp[er][ec] = count;
            }
        }

        return dp[ER][EC];
    }

    public static int mazePathJump_memo(int er, int ec, int[][] dp, int[][] dir) {
        if (er == 0 && ec == 0) {
            return dp[er][ec] = 1;
        }

        if (dp[er][ec] != 0)
            return dp[er][ec];

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = er + dir[d][0];
            int c = ec + dir[d][1];
            while (r >= 0 && c >= 0 && r < dp.length && c < dp.length) {
                count += mazePathJump_memo(r, c, dp, dir);
                r += dir[d][0];
                c += dir[d][1];
            }
        }

        return dp[er][ec] = count;
    }

    public static int mazePathJump_tabu(int ER, int EC, int[][] dp, int[][] dir) {
        for (int er = 0; er <= ER; er++) {
            for (int ec = 0; ec <= EC; ec++) {
                if (er == 0 && ec == 0) {
                    dp[er][ec] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = er + dir[d][0];
                    int c = ec + dir[d][1];
                    while (r >= 0 && c >= 0 && r < dp.length && c < dp.length) {
                        count += mazePathJump_memo(r, c, dp, dir);
                        r += dir[d][0];
                        c += dir[d][1];
                    }
                }

                dp[er][ec] = count;
            }
        }

        return dp[ER][EC];
    }
    
    public static void main(String[] args) {
        int n = 3, m = 3;
        int er = n - 1, ec = m - 1;
        int[][] dp = new int[n][m];
        int[][] dir = { { -1, 0 }, { 0, -1 }, { -1, -1 } };
        System.out.println(mazePath_memo(2, 2,dp, dir));
    }
}
