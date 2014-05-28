import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null) {
            return res;
        }
        int n = matrix.length;
        if (n == 0) {
            return res;
        }
        int m = matrix[0].length;
        int count = n * m;
        int x = 0;
        int y = -1;
        --n;
        for (int k = 0; count > 0; ++k) {
            System.out.println("count = " + count);
            int step = 1;
            if (k % 2 == 0) {
                if ((k / 2) % 2 != 0) {
                    step = -1;
                }
                y += step;
                for (int i = 0; i < m; ++i) {
                    res.add(matrix[x][y]);
                    y += step;
                }
                y -= step;
                count -= m;
                --m;
            } else {
                if (((k - 1) / 2) % 2 != 0) {
                    step = -1;
                }
                x += step;
                for (int i = 0; i < n; ++i) {
                    res.add(matrix[x][y]);
                    x += step;
                }
                x -= step;
                count -= n;
                --n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix solver = new SpiralMatrix();
        int[][] matrix = null;
        matrix = new int[][] {
            new int[] {3},
            new int[] {2},
        };
        for (Integer x : solver.spiralOrder(matrix)) {
            System.out.printf("%4d", x);
        }
        System.out.println();
    }
}
