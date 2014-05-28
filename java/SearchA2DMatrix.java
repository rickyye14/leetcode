public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        int row = searchRow(matrix, target);
        System.out.println("row = " + row);
        int low = 0;
        int high = m - 1;
        int mid;
        // notice the details to use binary search
        while (low <= high) {
            mid = (low + high) / 2;
            if (matrix[row][mid] < target) {
                low = mid + 1;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private int searchRow(int[][] matrix, int target) {
        int n = matrix.length;
        int low = 0;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (matrix[mid][0] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Math.max(high, 0);
    }

    public static void main(String[] args) {
        SearchA2DMatrix solver = new SearchA2DMatrix();
        int[][] matrix = null;
        matrix = new int[][] {
            new int[] {1, 3, 5, 7},
            new int[] {10, 11, 16, 20}
        };
        solver.searchMatrix(matrix, 3);
    }
}
