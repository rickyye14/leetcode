#include "base_include.h"

#define DEBUG

class MedianOfTwoSortedArrays {
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        if (0 == (n + m) % 2) {
            return (findKthElementInTwoArrays(A, m, B, n, (n + m) / 2 - 1) 
                + findKthElementInTwoArrays(A, m, B, n, (n + m) / 2)) * 0.5;
        } else {
            return findKthElementInTwoArrays(A, m, B, n, (n + m) / 2);
        }
    }

private:
    int findKthElementInTwoArrays(int A[], int na, int B[], int nb, int k) {
        int res = -1;
        int ma = -1, mb = -1;
        while (true) {
#ifdef DEBUG
            cout << "A =";
            for (int i = 0; i < na; ++i) {
                cout << " " << A[i];
            }
            cout << endl;

            cout << "B =";
            for (int i = 0; i < nb; ++i) {
                cout << " " << B[i];
            }
            cout << endl;

            cout << "k = " << k << endl;
#endif
            if (0 == na) {
                res = B[k];
                break;
            }
            if (0 == nb) {
                res = A[k];
                break;
            }
            if (0 == k) {
                res = min(A[0], B[0]);
                break;
            }
            ma = na >> 1;
            mb = nb >> 1;
            if (k < ma + mb + 1) {
                if (A[ma] < B[mb]) {
                    nb = mb;
                } else {
                    na = ma;
                }
            } else if (k > ma + mb + 1) {
                if (A[ma] < B[mb]) {
                    A += ma + 1;
                    na -= ma + 1;
                    k -= ma + 1;    //take care of updating k
                } else {
                    B += mb + 1;
                    nb -= mb + 1;
                    k -= mb + 1;
                }
            } else {
                if (ma < na - 1 && A[ma + 1] < B[mb]) {
                    nb = mb;
                } else if (mb < nb - 1 && B[mb + 1] < A[ma]) {
                    na = ma;
                } else {
                    res = max(A[ma], B[mb]);
                    break;
                }
            }
        }
#ifdef DEBUG
        cout << "res = " << res << endl;
#endif
        return res;
    }
};

int main(int argc, char *argv[]) {
    MedianOfTwoSortedArrays solver;
    int A[] = {6, 7, 9, 10};
    int B[] = {1, 2, 3, 4, 5, 8};
    cout << solver.findMedianSortedArrays(A, sizeof(A) / sizeof(int), B, sizeof(B) / sizeof(int)) << endl;
    return 0;
}
