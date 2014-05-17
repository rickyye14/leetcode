public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        int n = strs.length;
        /**
         * Missed the case n == 0
         */
        if (n == 0) {
            return "";
        }
        for (int i = 0; i < n; ++i) {
            if (strs[i] == null) {
                return "";
            }
        }
        int[] lens = new int[n];
        for (int i = 0; i < n; ++i) {
            lens[i] = strs[i].length();
        }
        int ptr = 0;
        for ( ; ; ++ptr) {
            boolean sign = true;
            for (int i = 0; i < n; ++i) {
                if (ptr >= lens[i]) {
                    sign = false;
                    break;
                }
            }
            if (!sign) {
                break;
            }
            char ch = strs[0].charAt(ptr);
            for (int i = 1; i < n; ++i) {
                if (strs[i].charAt(ptr) != ch) {
                    sign = false;
                    break;
                }
            }
            if (!sign) {
                break;
            }
        }
        return strs[0].substring(0, ptr);
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = new String[4];
        strs[0] = "abcd";
        strs[1] = "abcde";
        strs[2] = "abc";
        strs[3] = "abcdf";
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
