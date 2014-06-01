public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null) {
            return false;
        }
        int n = A.length;
        int low = 0;
        int high = n - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == A[mid]) {
                return true;
            } else {
                if (A[low] < A[mid]) {
                    if (A[low] <= target && target < A[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (A[mid] < A[high]) {
                    if (A[mid] < target && target <= A[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else if (A[low] > A[mid]) {
                    high = mid - 1;
                } else if (A[mid] > A[high]) {
                    low = mid + 1;
                } else {
                    ++low;
                    --high;
                }
            }
        }
        return false;
    }
}
