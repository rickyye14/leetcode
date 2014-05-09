public class MedianOfTwoSortedArrays {

    public int findKthElementSortedArrays(int[] A, int[] B, int k) {
        assert(A != null && B != null && 0 <= k && k < A.length + B.length);
        int aStart = 0;
        int aEnd = A.length - 1;
        int bStart = 0;
        int bEnd = B.length - 1;
        int aMid;
        int bMid;
        int res = -1;

        while (true) {
            if (aEnd < aStart) {
                res = B[bStart + k];
                break;
            }
            if (bEnd < bStart) {
                res = A[aStart + k];
                break;
            }
            if (k == 0) {
                res = Math.min(A[aStart], B[bStart]);
                break;
            }
            aMid = (aStart + aEnd) / 2 - aStart;
            bMid = (bStart + bEnd) / 2 - bStart;
            if (A[aMid] < B[bMid]) {
                if (k <= aMid + bMid + 1) {
                    bEnd = bStart + bMid;
                } else {
                    aStart += aMid + 1;
                    k -= aMid + 1;
                }
            } else {
                if (k <= aMid + bMid + 1) {
                    aEnd = aStart + aMid;
                } else {
                    bStart += bMid + 1;
                    k -= bMid + 1;
                }
            }
        }

        return res;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        if ((n1 + n2) % 2 != 0) {
            return (double) findKthElementSortedArrays(A, B, (n1 + n2) / 2);
        } else {
            return (findKthElementSortedArrays(A, B, (n1 + n2) / 2 - 1)
                    + findKthElementSortedArrays(A, B, (n1 + n2) / 2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] A = null;
        int[] B = null;
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        A = new int[] {1, 1, 1};
        B = new int[] {1, 1, 1};
        System.out.println(solution.findMedianSortedArrays(A, B));

        A = new int[] {2};
        B = new int[] {1, 2};
        System.out.println(solution.findMedianSortedArrays(A, B));

        A = new int[] {1, 1};
        B = new int[] {1, 2};
        System.out.println(solution.findMedianSortedArrays(A, B));

        A = new int[] {2, 3, 4, 5};
        B = new int[] {1, 2};
        System.out.println(solution.findMedianSortedArrays(A, B));
    }
}
