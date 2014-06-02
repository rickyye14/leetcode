public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n = s.length();
        int m = p.length();
        int sp = 0;
        int pp = 0;
        int st = -1;
        int pt = -1;
        while (sp < n) {
            if (pp < m) {
                if (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?') {
                    ++sp;
                    ++pp;
                    continue;
                }
                if (p.charAt(pp) == '*') {
                    st = sp;
                    pt = ++pp;
                    continue;
                }
            }
            if (pt != -1) {
                sp = ++st;
                pp = pt;
                continue;
            }
            return false;
        }
        while (pp < m && p.charAt(pp) == '*') {
            ++pp;
        }
        return pp == m;
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
