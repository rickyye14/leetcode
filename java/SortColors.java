public class SortColors {
    public void sortColors(int[] A) {
        if (A == null) {
            return;
        }
        int n = A.length;
        if (n == 0) {
            return;
        }
        int low = 1;
        int high = n;
        while (true) {
            while (low < n - 1 && A[++low] < 2) {
            }
        }
    }
}
