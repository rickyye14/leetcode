public class SortColors {
    public void sortColors(int[] A) {
        if (A == null) {
            return;
        }
        int n = A.length;
        if (n == 0) {
            return;
        }
        int m = 3;
        int[] ptrs = new int[m];
        for (int i = 0; i < n; ++i) {
            int k = m - A[i];
            for (int j = 0; j < k; ++j) {
                int t = m - 1 - j;
                A[ptrs[t]++] = t;
            }
        }
    }
}
