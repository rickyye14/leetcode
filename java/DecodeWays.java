public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (s.charAt(0) - '0' != 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) - '0' != 0) {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            int a = s.charAt(i - 2) - '0';
            int b = s.charAt(i - 1) - '0';
            int c = a * 10 + b;
            if (b != 0) {
                dp[i] += dp[i - 1];
            }
            if (10 <= c && c <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
