public class MaximumSubarray {
    private int maxCrossingSubArray(int[] A, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid; i >= low; --i) {
            leftSum += A[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid + 1; i <= high; ++i) {
            rightSum += A[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }

    private int maxSubArray(int[] A, int low, int high) {
        if (low == high) {
            return A[low];
        }
        int mid = (low + high) / 2;
        int leftSum = maxSubArray(A, low, mid);
        int rightSum = maxSubArray(A, mid + 1, high);
        int crossingSum = maxCrossingSubArray(A, low, mid, high);
        if (leftSum >= rightSum && leftSum >= crossingSum) {
            return leftSum;
        }
        if (rightSum >= leftSum && rightSum >= crossingSum) {
            return rightSum;
        }
        return crossingSum;
    }

    public int maxSubArray(int[] A) {
        return maxSubArray(A, 0, A.length - 1);
    }
}
