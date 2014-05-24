public class TrappingRainWater {
    public int trap(int[] bars) {
        if (bars == null) {
            return 0;
        }
        int n = bars.length;
        if (n == 0) {
            return 0;
        }
        int[] leftHighest = new int[n];
        int[] rightHighest = new int[n];
        leftHighest[0] = bars[0];
        for (int i = 1; i < n; ++i) {
            leftHighest[i] = Math.max(leftHighest[i - 1], bars[i]);
        }
        rightHighest[n - 1] = bars[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightHighest[i] = Math.max(rightHighest[i + 1], bars[i]);
        }
        int sum = 0;
        for (int i = 1; i < n - 1; ++i) {
            sum += Math.min(leftHighest[i], rightHighest[i]) - bars[i];
        }
        return sum;
    }
}
