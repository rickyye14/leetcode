import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            throw new IllegalArgumentException();
        }
        int n = num.length;
        Arrays.sort(num);
        int closest = num[0] + num[1] + num[2];
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                int k = target - num[i] - num[j + 1];
                // don't need to add the restrictions condition
                /*
                if (k < num[j + 1]) {
                    break;
                }
                if (k > num[n - 1]) {
                    continue;
                }
                */
                int low = j + 1;
                int high = n - 1;
                int mid = (low + high) / 2;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (num[mid] == k) {
                        break;
                    } else if (num[mid] < k) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                int sum = 0;
                sum = num[i] + num[j] + num[mid];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (mid > j + 1) {
                    sum = num[i] + num[j] + num[mid - 1];
                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }
                }
                if (mid < n - 1) {
                    sum = num[i] + num[j] + num[mid + 1];
                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }
}
