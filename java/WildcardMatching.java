public class WildcardMatching {
    private int preCheck(String s, String p) {
        int n = s.length();
        int m = p.length();
        int start = 0;
        for (int i = 0; i < m; ++i) {
            int j = i;
            while (j < m && (p.charAt(j) == '*' || p.charAt(j) == '?')) {
                ++j;
            }
            i = j;
            if (j == m) {
                break;
            }
            while (j < m && p.charAt(j) != '*' && p.charAt(j) != '?') {
                ++j;
            }
            int index = s.indexOf(p.substring(i, j), start);
            if (index < 0) {
                return 0;
            }
            start = index + j - i;
            i = j - 1;
        }
        if (start == n || p.charAt(m - 1) == '*') {
            return 2;
        }
        return 1;
    }

    private boolean searchPattern(String s, String p, int i, int j, int[] remains) {
        int n = s.length();
        int m = p.length();
        if (i == n && j == m) {
            return true;
        }
        if (i == n) {
            return remains[j] == 0;
        }
        if (j == m) {
            return false;
        }
        if (n - i < remains[j]) {
            return false;
        }
        char ch = p.charAt(j);
        if (ch == '?') {
            return searchPattern(s, p, i + 1, j + 1, remains);
        } else if (ch == '*') {
            for (int k = i; k <= n && n - k >= remains[j + 1]; ++k) {
                if (searchPattern(s, p, k, j + 1, remains)) {
                    return true;
                }
            }
        } else {
            if (s.charAt(i) != p.charAt(j)) {
                return false;
            }
            return searchPattern(s, p, i + 1, j + 1, remains);
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n = s.length();
        int m = p.length();
        StringBuilder pb = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            int j = i;
            while (j < m && p.charAt(j) != '*') {
                pb.append(p.charAt(j));
                ++j;
            }
            if (j == m) {
                break;
            }
            pb.append('*');
            while (j < m && p.charAt(j) == '*') {
                ++j;
            }
            i = j - 1;
        }
        p = pb.toString();
        m = p.length();
        int flag = preCheck(s, p);
        if (flag == 0) {
            return false;
        }
        if (flag == 2) {
            return true;
        }
        String rs = new StringBuilder(s).reverse().toString();
        String rp = new StringBuilder(p).reverse().toString();
        flag = preCheck(rs, rp);
        if (flag == 0) {
            return false;
        }
        if (flag == 2) {
            return true;
        }
        int[] remains = new int[m + 1];
        remains[m] = 0;
        for (int i = m - 1; i >= 0; --i) {
            remains[i] = remains[i + 1];
            if (p.charAt(i) != '*') {
                ++remains[i];
            }
        }
        return searchPattern(s, p, 0, 0, remains);
    }

    public static void main(String[] args) {
        WildcardMatching solver = new WildcardMatching();
        System.out.println(solver.isMatch("aa", "a"));
        System.out.println(solver.isMatch("aa", "aa"));
        System.out.println(solver.isMatch("aaa", "aa"));
        System.out.println(solver.isMatch("aa", "*"));
        System.out.println(solver.isMatch("aa", "a*"));
        System.out.println(solver.isMatch("ab", "?*"));
        System.out.println(solver.isMatch("aab", "c*a*b"));
        System.out.println(solver.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        System.out.println(solver.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "*******a"));
        System.out.println(solver.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "*******b"));
        System.out.println(solver.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        System.out.println(solver.isMatch("baaabbabbbaabbbbbbabbbaaabbaabbbbbaaaabbbbbabaaaaabbabbaabaaababaabaaabaaaabbabbbaabbbbbaababbbabaaabaabaaabbbaababaaabaaabaaaabbabaabbbabababbbbabbaaababbabbaabbaabbbbabaaabbababbabababbaabaabbaaabbba", "*b*ab*bb***abba*a**ab***b*aaa*a*b****a*b*bb**b**ab*ba**bb*bb*baab****bab*bbb**a*a*aab*b****b**ba**abba"));
    }
}
