public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int n = digits.length;
        if (n == 0) {
            return new int[0];
        }
        int[] res = null;
        int i = n - 1;
        for ( ; i >= 0 && digits[i] == 9; --i) {
            ;
        }
        if (i < 0) {
            res = new int[n + 1];
            res[0] = 1;
            for (int j = 1; j <= n; ++j) {
                res[j] = 0;
            }
            return res;
        }
        ++digits[i];
        for (++i; i < n; ++i) {
            digits[i] = 0;
        }
        return digits;
    }
}
