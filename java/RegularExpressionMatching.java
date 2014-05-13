public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return matchSearch(s, p, s.length(), p.length(), 0, 0);
    }

    public boolean matchSearch(String s, String p, int sLen, int pLen, int sPtr, int pPtr) {
        if (sPtr > sLen || pPtr > pLen) {
            return false;
        }
        if (pPtr == pLen) {
            if (sPtr == sLen) {
                return true;
            } else {
                return false;
            }
        }
        if (sPtr == sLen) {
            /**
             * Notice: if p[ptr] could be a-z or '.'
             */
            if (pPtr == pLen - 1 || p.charAt(pPtr + 1) != '*') {
                return false;
            }
        }
        if (p.charAt(pPtr) != '.') {
            if (pPtr == pLen - 1) {
                if (s.charAt(sPtr) == p.charAt(pPtr)) {
                    return matchSearch(s, p, sLen, pLen, sPtr + 1, pPtr + 1);
                } else {
                    return false;
                }
            } else {
                if (p.charAt(pPtr + 1) != '*') {
                    if (s.charAt(sPtr) == p.charAt(pPtr)) {
                        return matchSearch(s, p, sLen, pLen, sPtr + 1, pPtr + 1);
                    } else {
                        return false;
                    }
                } else {
                    if (matchSearch(s, p, sLen, pLen, sPtr, pPtr + 2)) {
                        return true;
                    }
                    for (int i = sPtr; i < sLen; ++i) {
                        if (s.charAt(i) != p.charAt(pPtr)) {
                            break;
                        }
                        if (matchSearch(s, p, sLen, pLen, i + 1, pPtr + 2)) {
                            return true;
                        }
                    }
                }
            }
        } else /* if (p.charAt(pPtr) == '.') */ {
            if (pPtr == pLen - 1) {
                return matchSearch(s, p, sLen, pLen, sPtr + 1, pPtr + 1);
            } else {
                if (p.charAt(pPtr + 1) != '*') {
                    return matchSearch(s, p, sLen, pLen, sPtr + 1, pPtr + 1);
                } else {
                    if (matchSearch(s, p, sLen, pLen, sPtr, pPtr + 2)) {
                        return true;
                    }
                    for (int i = sPtr; i < sLen; ++i) {
                        if (matchSearch(s, p, sLen, pLen, i + 1, pPtr + 2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        String s = null;
        String p = null;

        s = "aa";
        p = "a";
        System.out.println(solution.isMatch(s, p));

        s = "aa";
        p = "aa";
        System.out.println(solution.isMatch(s, p));

        s = "aaa";
        p = "aa";
        System.out.println(solution.isMatch(s, p));

        s = "aa";
        p = "a*";
        System.out.println(solution.isMatch(s, p));

        s = "aa";
        p = ".*";
        System.out.println(solution.isMatch(s, p));

        s = "ab";
        p = ".*";
        System.out.println(solution.isMatch(s, p));

        s = "aab";
        p = "c*a*b";
        System.out.println(solution.isMatch(s, p));

        s = "a";
        p = "ab*";
        System.out.println(solution.isMatch(s, p));
    }
}
