public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            if (matrix[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; ++j) {
            if (matrix[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (matrix[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
