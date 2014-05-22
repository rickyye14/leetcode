public class SearchForARange {
    private int leftmost(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (A[low] == target) {
            return low;
        }
        return -1;
    }

    private int rightmost(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (A[high] == target) {
            return high;
        }
        return -1;
    }
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (A == null) {
            return res;
        }
        int n = A.length;
        if (n == 0) {
            return res;
        }
        if (target < A[0] || target > A[n - 1]) {
            return res;
        }
        res[0] = leftmost(A, target);
        res[1] = rightmost(A, target);
        return res;
    }

    public static void main(String[] args) {
        SearchForARange solution = new SearchForARange();
        int[] A = null;
        int[] res;

        A = new int[] {5, 7, 7, 8, 8, 10};
        res = solution.searchRange(A, 8);
        System.out.println(res[0] + ", " + res[1]);
        res = solution.searchRange(A, 6);
        System.out.println(res[0] + ", " + res[1]);
        res = solution.searchRange(A, 9);
        System.out.println(res[0] + ", " + res[1]);
        res = solution.searchRange(A, 5);
        System.out.println(res[0] + ", " + res[1]);
    }
}
