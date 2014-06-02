public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }
        int[] bars = new int[m + 1];
        for (int j = 0; j < m; ++j) {
            int h = 0;
            for (int i = 0; i < n; ++i) {
                if (matrix[i][j] != '0') {
                    ++h;
                }
            }
            bars[j] = h;
        }
        bars[m] = 0;
        ++m;
        int[] stack = new int[m];
        int top = 0;
        int largest = 0;
        for (int i = 0; i < m; ++i) {
            if (top == 0 || bars[stack[top - 1]] <= bars[i]) {
                stack[top++] = i;
            } else {
                int idx = stack[--top];
                largest = Math.max(largest, bars[idx] * (top == 0 ? i : i - stack[top - 1] - 1));
                --i;
            }
        }
        return largest;
    }
}
