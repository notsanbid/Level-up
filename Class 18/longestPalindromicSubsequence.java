public class longestPalindromicSubsequence {
    // https://leetcode.com/problems/longest-palindromic-subsequence
    public static void display(int[] dp) {
        for (int ele : dp)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for (int[] d : dp)
            display(d);
    }

    public static int longestPlaindromicSubsequence_memo(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return dp[i][j] = i == j ? 1 : 0;
        }

        if (dp[i][j] != 0)
            return dp[i][j];

        if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = longestPlaindromicSubsequence_memo(str, i + 1, j - 1, dp) + 2;
        else
            return dp[i][j] = Math.max(longestPlaindromicSubsequence_memo(str, i + 1, j, dp), longestPlaindromicSubsequence_memo(str, i, j - 1, dp));
    }

    // Its subsequence, that is, each character has an option of coming and not coming
    // If 2 chars are there, we have following option : x x (1)
    //                                                  1 x (2)
    //                                                  x 1 (3)
    //                                                  1 1 (4)
    // We have seen case 2,3,4 above; but where is case 1?
    // Case 1 gets covered in case 2 to 4. More details in SS
    
    public static int longestPlaindromicSubsequence_tabu(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = i == j ? 1 : 0;
                    continue ;
                }
        
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
       
        return dp[I][J];
        
        // The tabulation is very important. We observed from memo that DP is getting filled diagonally,
        // So we emulated the same here.
    }
}