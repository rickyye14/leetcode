public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        int n = S.length();
        int m = T.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = m; j >= 1; --j) {
                dp[j] += S.charAt(i - 1) == T.charAt(j - 1) ? dp[j - 1] : 0;
            }
        }
        return dp[m];
    }
}
