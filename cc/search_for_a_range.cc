#include "base_include.h"

class SearchForARange {
public:
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> result;
        result.push_back(leftmost(A, n, target));
        result.push_back(rightmost(A, n, target));
        return result;
    }

private:
    int leftmost(int A[], int n, int target) {
        int result = 0;
        int low = 0, high = n - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low >= n || A[low] != target) {
            result = -1;
        } else {
            result = low;
        }
        return result;
    }

    int rightmost(int A[], int n, int target) {
        int result = 0;
        int low = 0, high = n - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < 0 || A[high] != target) {
            result = -1;
        } else {
            result = high;
        }
        return result;
    }
};

int main(int argc, char *argv[]) {
    SearchForARange solver;
    int A[]{5, 7, 7, 8, 8, 10};
    vector<int> result;
    result = solver.searchRange(A, 6, 8);
    cout << result[0] << ", " << result[1] << endl;

    result = solver.searchRange(A, 6, 7);
    cout << result[0] << ", " << result[1] << endl;

    result = solver.searchRange(A, 6, 4);
    cout << result[0] << ", " << result[1] << endl;

    result = solver.searchRange(A, 6, 10);
    cout << result[0] << ", " << result[1] << endl;

    result = solver.searchRange(A, 6, 11);
    cout << result[0] << ", " << result[1] << endl;
    return 0;
}
