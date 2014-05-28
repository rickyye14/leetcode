public class RotateImage {
    private class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position(Position that) {
            this.x = that.x;
            this.y = that.y;
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int m = matrix[0].length;
        if (n != m) {
            return;
        }
        for (int k = 0; k < n / 2; ++k) {
            Position p0 = new Position(k, k);
            Position p1 = new Position(k, n - 1 - k);
            Position p2 = new Position(n - 1 - k, n - 1 - k);
            Position p3 = new Position(n - 1 - k, k);
            for (int i = 0; i < m - 1; ++i) {
                int temp           = matrix[p3.x][p3.y];
                matrix[p3.x][p3.y] = matrix[p2.x][p2.y];
                matrix[p2.x][p2.y] = matrix[p1.x][p1.y];
                matrix[p1.x][p1.y] = matrix[p0.x][p0.y];
                matrix[p0.x][p0.y] = temp;
                ++p0.y;
                ++p1.x;
                --p2.y;
                --p3.x;
            }
            display(matrix);
            m -= 2;
        }
    }

    public void display(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage solver = new RotateImage();
        int[][] matrix = null;
        matrix = new int[][] {
            new int[] {1, 2, 3, 4},
            new int[] {5, 6, 7, 8},
            new int[] {9, 10, 11, 12},
            new int[] {13, 14, 15, 16}
        };

        solver.rotate(matrix);
        solver.display(matrix);
    }
}
