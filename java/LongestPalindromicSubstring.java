public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int n = s.length();
        if (n == 0) {
            return s;
        }
        boolean[][] marked = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            marked[i][i] = true;
        }
        int start = 0;
        int end = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                marked[i][i + 1] = true;
            }
            for (int j = i + 2; j < n; ++j) {
                if (marked[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    marked[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n - 1 && end - start < n - 1 - i; ++i) {
            for (int j = n - 1; j > i; --j) {
                if (marked[i][j] && end - start < j - i) {
                    start = i;
                    end = j;
                    break;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome2(String s) {
        if (s == null) {
            return null;
        }
        int n = s.length();
        if (n == 0) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; ++i) {
            int left = i;
            int right = i;
            for ( ; 0 <= left && right < n && s.charAt(left) == s.charAt(right); --left, ++right) {
                ;
            }
            ++left;
            --right;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }
        for (int i = 0; i < n - 1; ++i) {
            int left = i;
            int right = i + 1;
            for ( ; 0 <= left && right < n && s.charAt(left) == s.charAt(right); --left, ++right) {
                ;
            }
            ++left;
            --right;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s;
        s = "a";
        System.out.println(solution.longestPalindrome(s));
        s = "bb";
        System.out.println(solution.longestPalindrome(s));
        s = "add";
        System.out.println(solution.longestPalindrome(s));
        s = "abdcdbef";
        System.out.println(solution.longestPalindrome(s));
        s = "abddbf";
        System.out.println(solution.longestPalindrome(s));

        s = "a";
        System.out.println(solution.longestPalindrome2(s));
        s = "bb";
        System.out.println(solution.longestPalindrome2(s));
        s = "add";
        System.out.println(solution.longestPalindrome2(s));
        s = "abdcdbef";
        System.out.println(solution.longestPalindrome2(s));
        s = "abddbf";
        System.out.println(solution.longestPalindrome2(s));
    }
}
