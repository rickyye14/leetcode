public class MergeSortedArray {
    public void merge(int A[], int m, int[] B, int n) {
        if (A == null || B == null) {
            return;
        }
        if (A.length != m + n) {
            return;
        }
        if (B.length != n) {
            return;
        }
        int tail = n + m;
        for ( ; m > 0 && n > 0; ) {
            if (A[m - 1] < B[n - 1]) {
                A[--tail] = B[--n];
            } else {
                A[--tail] = A[--m];
            }
        }
        for ( ; m > 0; ) {
            A[--tail] = A[--m];
        }
        for ( ; n > 0; ) {
            A[--tail] = B[--n];
        }
    }
}
