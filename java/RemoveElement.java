import java.util.Arrays;

public class RemoveElement {
    private int leftmost(int key, int[] A, int left, int right) {
        if (left < 0 || right >= A.length) {
            throw new IllegalArgumentException();
        }
        int low = left;
        int high = right;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (left <= low && low <= right) {
            if (A[low] == key) {
                return low;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    private int rightmost(int key, int[] A, int left, int right) {
        if (left < 0 || right >= A.length) {
            throw new IllegalArgumentException();
        }
        int low = left;
        int high = right;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (left <= high && high <= right) {
            if (A[high] == key) {
                return high;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public int removeElement(int[] A, int elem) {
        if (A == null) {
            return 0;
        }
        int n = A.length;
        Arrays.sort(A);
        int leftmost = leftmost(elem, A, 0, n - 1);
        int rightmost = rightmost(elem, A, 0, n - 1);
        if (leftmost == -1 || rightmost == -1) {
            return n;
        }
        int m = rightmost - leftmost + 1;
        for (int i = rightmost + 1; i < n; ++i) {
            A[i - m] = A[i];
        }
        return n - m;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
    }
}
