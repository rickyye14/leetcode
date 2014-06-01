public class PermutationSequence {
    private int selectKth(int[] arr, int k) {
        int n = arr.length;
        int[] buffer = new int[n];
        for (int i = 0; i < n; ++i) {
            buffer[i] = arr[i];
        }
        for (int i = 0; i <= k; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (buffer[j] != -1 && buffer[j] < buffer[minIndex] || buffer[minIndex] == -1) {
                    minIndex = j;
                }
            }
            int temp = buffer[i];
            buffer[i] = buffer[minIndex];
            buffer[minIndex] = temp;
            buffer[i] = minIndex;
        }
        return buffer[k];
    }

    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; ++i) {
            fac[i] = fac[i - 1] * i;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = i + 1;
        }
        --k;
        k %= fac[n];
        StringBuilder perm = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int kthIndex = selectKth(arr, k / fac[n - 1 - i]);
            perm.append(arr[kthIndex]);
            arr[kthIndex] = -1;
            k %= fac[n - 1 - i];
        }
        return perm.toString();
    }
}
