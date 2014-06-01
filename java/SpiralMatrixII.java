public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int x = 0;
        int y = -1;
        int top = 0;
        int count = n * n;
        int m = n;
        --n;
        for (int k = 0; top < count; ++k) {
            int step = 1;
            if (k % 2 == 0) {
                if (k / 2 % 2 != 0) {
                    step = -1;
                }
                for (int i = 0; i < m; ++i) {
                    y += step;
                    matrix[x][y] = ++top;
                }
                --m;
            } else {
                if ((k - 1) / 2 % 2 != 0) {
                    step = -1;
                }
                for (int i = 0; i < n; ++i) {
                    x += step;
                    matrix[x][y] = ++top;
                }
                --n;
            }
        }
        return matrix;
    }
}
