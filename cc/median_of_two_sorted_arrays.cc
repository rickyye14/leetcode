#include "base_include.h"

class MedianOfTwoSortedArrays {
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        if ( (m + n) % 2 == 0) {
            return (findKthElementInTwoArrays(A, m, B, n, (m + n) / 2) + 
                    findKthElementInTwoArrays(A, m, B, n, (m + n) / 2 + 1) ) * 0.5;
        } else {
            return findKthElementInTwoArrays(A, m, B, n, (m + n + 1) / 2);
        }
    }

private:
    int findKthElementInTwoArrays(int A[], int m, int B[], int n, int k) {
        int l1 = 0, r1 = m - 1, mid1 = 0;
        int l2 = 0, r2 = n - 1, mid2 = 0;
        while (l1 <= r1 && l2 <= r2) {
            mid1 = l1 + (r1 - l1) / 2;
            mid2 = l2 + (r2 - l2) / 2;
            if (A[mid1] <= B[mid2]) {
                if (k <= mid1 - l1 + mid2 - l2 + 1) {
                    r2 = mid2 - 1;
                } else {
                    k -= mid1 - l1 + 1;
                    l1 = mid1 + 1;
                }
            } else {
                if (k <= mid1 - l1 + mid2 - l2 + 1) {
                    r1 = mid1 - 1;
                } else {
                    k -= mid2 - l2 + 1;
                    l2 = mid2 + 1;
                }
            }
        }
        if (l1 <= r1) {
            return A[l1 + k - 1];
        } else {
            return B[l2 + k - 1];
        }
    }
};

int main(int argc, char *argv[]) {
    MedianOfTwoSortedArrays solver;
    int A[] = {6, 7, 9, 10};
    int B[] = {1, 2, 3, 4, 5, 8};
    cout << solver.findMedianSortedArrays(A, sizeof(A) / sizeof(int), B, sizeof(B) / sizeof(int)) << endl;
    return 0;
}
