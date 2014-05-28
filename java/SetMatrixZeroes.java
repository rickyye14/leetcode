public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int m = matrix[0].length;
        boolean clearRow = false;
        boolean clearCol = false;
        if (matrix[0][0] == 0) {
            clearRow = true;
            clearCol = true;
        } else {
            for (int i = 1; i < n; ++i) {
                if (matrix[i][0] == 0) {
                    clearRow = true;
                    break;
                }
            }
            for (int j = 1; j < m; ++j) {
                if (matrix[0][j] == 0) {
                    clearCol = true;
                    break;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            if (matrix[i][0] != 0) {
                continue;
            }
            for (int j = 1; j < m; ++j) {
                matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < m; ++j) {
            if (matrix[0][j] != 0) {
                continue;
            }
            for (int i = 1; i < n; ++i) {
                matrix[i][j] = 0;
            }
        }
        if (clearRow) {
            for (int i = 0; i < n; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (clearCol) {
            for (int j = 0; j < m; ++j) {
                matrix[0][j] = 0;
            }
        }
    }
}
