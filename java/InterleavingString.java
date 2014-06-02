public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        if (n + m != l) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            char c1 = s1.charAt(i - 1);
            char c3 = s3.charAt(i - 1);
            if (c1 == c3) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            char c2 = s2.charAt(i - 1);
            char c3 = s3.charAt(i - 1);
            if (c2 == c3) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 2);
                char c4 = s3.charAt(i + j - 1);
                if (dp[i - 1][j - 1]) {
                    if (c1 == c3) {
                        dp[i][j - 1] = true;
                    }
                    if (c2 == c3) {
                        dp[i - 1][j] = true;
                    }
                }
                if (dp[i - 1][j]) {
                    if (c1 == c4) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j - 1]) {
                    if (c2 == c4) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[n][m];
    }

    private void display(boolean[][] dp) {
        int n = dp.length;
        if (n == 0) {
            return;
        }
        int m = dp[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (dp[i][j]) {
                    System.out.printf("%4d", 1);
                } else {
                    System.out.printf("%4d", 0);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InterleavingString solver = new InterleavingString();
        String s1 = null;
        String s2 = null;
        String s3 = null;

        s1 = "a";
        s2 = "";
        s3 = "a";
        System.out.println(solver.isInterleave(s1, s2, s3));

        s1 = "aa";
        s2 = "ab";
        s3 = "abaa";
        System.out.println(solver.isInterleave(s1, s2, s3));
    }
}
