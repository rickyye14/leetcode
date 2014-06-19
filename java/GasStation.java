public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) {
            return -1;
        }
        int n = gas.length;
        int m = cost.length;
        if (n != m || n < 1) {
            return -1;
        }
        int[] rest = new int[n];
        for (int i = 0; i < n; ++i) {
            rest[i] = gas[i] - cost[i];
        }
        int[] buffer = new int[n];
        for (int i = 0; i < n; ++i) {
            buffer[i] = rest[i];
        }
        rest = new int[n * 2];
        for (int i = 0; i < n * 2; ++i) {
            rest[i] = buffer[i % n];
        }
        int start = 0;
        int sum = 0;
        for (int i = 0; i < n * 2; ++i) {
            sum += rest[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
            if (i - start + 1 >= n) {
                return start;
            }
        }
        return -1;
    }
}
