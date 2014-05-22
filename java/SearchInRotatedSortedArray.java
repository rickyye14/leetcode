public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null) {
            return -1;
        }
        int n = A.length;
        if (n == 0) {
            return -1;
        }
        int low = 0;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[low] <= A[mid]) {
                if (A[low] <= target && target <= A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] <= target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] A = null;

        A = new int[] {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(A, 6));
        System.out.println(solution.search(A, 7));
        System.out.println(solution.search(A, 3));
        System.out.println(solution.search(A, 8));

        A = new int[] {3, 1};
        System.out.println(solution.search(A, 1));
    }
}
