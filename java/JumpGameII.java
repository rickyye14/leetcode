public class JumpGameII {
    public int jump(int[] A) {
        if (A == null) {
            return -1;
        }
        int n = A.length;
        int steps = 0;
        int last = 0;
        int current = 0;
        for (int i = 0; i < n; ++i) {
            if (i > last) {
                if (last == current && current < A[n - 1] - 1) {
                    return -1;
                }
                last = current;
                ++steps;
            }
            current = Math.max(current, i + A[i]);
        }
        return steps;
    }
}
