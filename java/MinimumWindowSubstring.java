public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (S == null || T == null) {
            return new String("");
        }
        int n = S.length();
        int m = T.length();
        if (m > n) {
            return new String("");
        }
        if (m == 0) {
            return new String("");
        }
        int[] buckets = new int[1 << 8];
        for (int i = 0; i < m; ++i) {
            int c = (int) T.charAt(i);
            ++buckets[c];
        }
        int count = 0;
        for (int i = 0; i < (1 << 8); ++i) {
            if (buckets[i] > 0) {
                ++count;
            }
        }
        int start = 0;
        int end = 0;
        int k = 0;
        int minDist = n + 1;
        int minStart = 0;
        int minEnd = n;
        for ( ; end < n; ) {
            for ( ; end < n && k < count; ++end) {
                int c = (int) S.charAt(end);
                if (--buckets[c] == 0) {
                    ++k;
                }
            }
            if (k < count) {
                break;
            }
            for ( ; start < end && k == count; ++start) {
                int c = (int) S.charAt(start);
                if (++buckets[c] > 0) {
                    --k;
                }
            }
            int dist = end - start + 1;
            if (dist < minDist) {
                minDist = dist;
                minStart = start - 1;
                minEnd = end;
            }
        }
        if (minDist > n) {
            return new String("");
        }
        return S.substring(minStart, minEnd);
    }
}
