/**
 *  @author Ricky
 *  @brief  "Two Sum" from LeetCode OJ
 *          -Record the indexes of the numbers
 *          -Sort the numbers using quick-sort with 3-median partition
 *          -Enumerate the first number
 *          -Binary search the second number
 *          -Retrieval the indexes of the two numbers
 */

public class TwoSum {
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private int median3(int[] numbers, int i, int j, int k) {
        if (numbers[i] < numbers[j]) {
            if (numbers[j] < numbers[k]) {
                return j;
            } else {
                if (numbers[i] < numbers[k]) {
                    return k;
                } else {
                    return i;
                }
            }
        } else {
            if (numbers[k] < numbers[j]) {
                return j;
            } else {
                if (numbers[k] < numbers[i]) {
                    return k;
                } else {
                    return i;
                }
            }
        }
    }

    private int partition(int[] numbers, int[] ids, int lo, int hi) {
        /**
         * @brief Need 3-median optimization if numbers is sorted
         */
        int m = median3(numbers, lo, (lo + hi) / 2, hi);
        swap(numbers, lo, m);
        swap(ids, lo, m);
        int i = lo;
        int j = hi + 1;
        int v = numbers[lo];
        while (true) {
            while (numbers[++i] < v && i < hi);
            while (v < numbers[--j] && lo < j);
            if (i >= j) {
                break;
            }
            swap(numbers, i, j);
            swap(ids, i, j);
        }
        swap(numbers, lo, j);
        swap(ids, lo, j);
        return j;
    }

    private void quickSort(int[] numbers, int[] ids, int lo, int hi) {
        if (hi - lo <= 2) {
            for (int i = lo; i < hi; ++i) {         //TLE with i = 0
                for (int j = i + 1; j <= hi; ++j) {
                    if (numbers[j] < numbers[i]) {
                        swap(numbers, i, j);
                        swap(ids, i, j);
                    }
                }
            }
            return;
        }
        int j = partition(numbers, ids, lo, hi);
        quickSort(numbers, ids, lo, j - 1);
        quickSort(numbers, ids, j + 1, hi);
    }

    private int binarySearch(int[] numbers, int key, int lo, int hi) {
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (numbers[mid] == key) {
                break;
            } else if (numbers[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return mid;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        int[] ids = new int[n];
        for (int i = 0; i < n; ++i) {       //miss the initialization
            ids[i] = i;
        }

        quickSort(numbers, ids, 0, n - 1);

        for (int i = 0; i < n - 1; ++i) {
            int key = target - numbers[i];
            int j = binarySearch(numbers, key, i + 1, n - 1);
            if (numbers[j] == key) {
                res[0] = ids[i] + 1;
                res[1] = ids[j] + 1;
                if (res[1] < res[0]) {      //miss the adjustment
                    swap(res, 0, 1);
                }
                break;      //miss the termination
            }
        }

        return res;
    }
}
