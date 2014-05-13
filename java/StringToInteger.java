public class StringToInteger {
    public int atoi(String s) { long res = 0;
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        boolean sign = true;
        int start = 0;
        int end = 0;
        for ( ; start < n && s.charAt(start) == ' '; ++start) {
            ;
        }
        if (s.charAt(start) == '-' || s.charAt(start) == '+') {
            sign = (s.charAt(start) == '+');
            ++start;
        }
        end = start;
        for ( ; end < n && '0' <= s.charAt(end) && s.charAt(end) <= '9'; ++end) {
            ;
        }
        if (start == end) {
            return 0;
        }
        for (int i = start; i < end; ++i) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return 0;
            }
        }
        for (int i = start; i < end; ++i) {
            res = res * 10 + s.charAt(i) - '0';
        }
        if (!sign) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();
        String s;
        s = " 45234";
        System.out.println(solution.atoi(s));

        s = " -0012a42";
        System.out.println(solution.atoi(s));
    }
}
