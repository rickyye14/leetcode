public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int l = i, r = i; 1 <= l && r <= n; --l, ++r) {
                if (s.charAt(l - 1) != s.charAt(r - 1)) {
                    break;
                }
                if (dp[l - 1] != Integer.MAX_VALUE) {
                    dp[r] = Math.min(dp[r], dp[l - 1] + 1);
                }
            }
            for (int l = i, r = i + 1; 1 <= l && r <= n; --l, ++r) {
                if (s.charAt(l - 1) != s.charAt(r - 1)) {
                    break;
                }
                if (dp[l - 1] != Integer.MAX_VALUE) {
                    dp[r] = Math.min(dp[r], dp[l - 1] + 1);
                }
            }
        }
        return dp[n] - 1;
    }
}
