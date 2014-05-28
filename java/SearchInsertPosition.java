public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null) {
            return 0;
        }
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        if (target < A[0]) {
            return 0;
        }
        if (target > A[n - 1]) {
            return n;
        }
        int low = 0;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        int[] A = null;

        A = new int[] {1, 3};
        System.out.println(solution.searchInsert(A, 2));

        A = new int[] {1, 3, 5, 6};
        System.out.println(solution.searchInsert(A, 2));
        System.out.println(solution.searchInsert(A, 7));
        System.out.println(solution.searchInsert(A, 3));
        System.out.println(solution.searchInsert(A, 1));
    }
}
