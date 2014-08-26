#include "base_include.h"

class SearchInsertPosition {
public:
    int searchInsert(int A[], int n, int target) {
        if (0 == n) {
            return 0;
        }
        if (target < A[0]) {
            return 0;
        }
        if (target > A[n - 1]) {
            return n;
        }
        int low = 0, high = n - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
