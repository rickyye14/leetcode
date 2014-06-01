public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int m = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            for ( ; j < n && A[i] == A[j]; ++j) {
                ;
            }
            int key = A[i];
            int t = j - i;
            if (t > 2) {
                t = 2;
            }
            for (int k = 0; k < t; ++k) {
                A[m++] = key;
            }
            i = j - 1;
        }
        return m;
    }
}
