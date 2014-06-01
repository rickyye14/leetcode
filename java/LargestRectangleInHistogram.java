public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] bars) {
        if (bars == null) {
            return 0;
        }
        int n = bars.length;
        if (n == 0) {
            return 0;
        }
        int[] stack = new int[n];
        int top = 0;
        int largest = 0;
        for (int i = 0; i < n; ++i) {
            if (top == 0 || bars[stack[top - 1]] <= bars[i]) {
                stack[top++] = i;
            } else {
                int idx = stack[--top];
                largest = Math.max(largest, bars[idx] * (top == 0 ? i : i - stack[top - 1] - 1));
                --i;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solver = new LargestRectangleInHistogram();
        int[] bars = null;

        bars = new int[] {2, 1, 5, 6, 2, 3};
        System.out.println(solver.largestRectangleArea(bars));
    }
}
