public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null) {
            return word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        int n = word1.length();
        int m = word2.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                dp[i][j] = n * m;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    // replace a character and let word1[i] equals word2[j]
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                // insert a character in word1
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                // insert a character in word2
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                // delete a character in word1
                dp[i][j - 1] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + 1);
                // delete a character in word2
                dp[i - 1][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        EditDistance solver = new EditDistance();
        System.out.println(solver.minDistance("hello", "world"));
        System.out.println(solver.minDistance("a", "ab"));
    }
}
