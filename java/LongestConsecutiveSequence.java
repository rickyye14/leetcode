import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null) {
            return 0;
        }
        int n = num.length;
        if (n < 2) {
            return n;
        }
        int[] uf = new int[n];
        for (int i = 0; i < n; ++i) {
            uf[i] = i;
        }
        int[] minValues = new int[n];
        int[] maxValues = new int[n];
        for (int i = 0; i < n; ++i) {
            minValues[i] = Integer.MAX_VALUE;
            maxValues[i] = Integer.MIN_VALUE;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            map.put(num[i], i);
        }
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(num[i] - 1)) {
                union(uf, i, map.get(num[i] - 1));
            }
            if (map.containsKey(num[i] + 1)) {
                union(uf, i, map.get(num[i] + 1));
            }
        }
        for (int i = 0; i < n; ++i) {
            int t = find(uf, map.get(num[i]));
            minValues[t] = Math.min(minValues[t], num[i]);
            maxValues[t] = Math.max(maxValues[t], num[i]);
        }
        int longest = 0;
        for (int i = 0; i < n; ++i) {
            if (minValues[i] == Integer.MAX_VALUE) {
                continue;
            }
            longest = Math.max(longest, maxValues[i] - minValues[i]);
        }
        return longest + 1;
    }

    private int find(int[] uf, int x) {
        int t = x;
        while (x != uf[x]) {
            x = uf[x];
        }
        while (t != x) {
            int s = uf[t];
            uf[t] = x;
            t = s;
        }
        return x;
    }

    private void union(int[] uf, int x, int y) {
        int rx = find(uf, x);
        int ry = find(uf, y);
        if (rx < ry) {
            uf[ry] = rx;
        } else {
            uf[rx] = ry;
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solver = new LongestConsecutiveSequence();
        int[] num = null;

        num = new int[] {0, -1};
        System.out.println(solver.longestConsecutive(num));
    }
}
