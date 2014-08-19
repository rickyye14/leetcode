#include "base_include.h"

class SearchInRotatedSortedArray {
public:
    int search(int A[], int n, int target) {
        int result = -1;
        if (0 == n) {
            return result;
        }
        int low = 0, high = n - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                result = mid;
                break;
            }
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
        return result;
    }
};

int main(int argc, char *argv[]) {
    SearchInRotatedSortedArray solver;
    int A[]{4, 5, 6, 7, 0, 1, 2};
    cout << solver.search(A, 7, 6) << endl;
    cout << solver.search(A, 7, 3) << endl;
    cout << solver.search(A, 7, 2) << endl;
    cout << solver.search(A, 7, 4) << endl;
    return 0;
}
