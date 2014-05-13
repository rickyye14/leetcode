public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        /**
         * Forget the negative numbers.
         */
        if (x < 0) {
            return false;
        }
        int t = x;
        long v = 0;
        while (t != 0) {
            v = v * 10 + t % 10;
            t /= 10;
        }
        return v == (long) x;
    }
}
