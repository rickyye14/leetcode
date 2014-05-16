/**
 * The basic idea is simple. At first, sort the <code>num</code> array. Then,
 * enumerate the value of <t>a</t> and <t>b</t>. Duplicate triples should be
 * considered. Finally, we use the binary search to find the number <t>c</t>.
 * Thus, we get a triple we need.
 */

import java.util.Arrays;
import java.util.ArrayList;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return res;
        }
        int n = num.length;
        if (n < 3) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < n - 2; ++i) {
            /**
             * ensure that there is no duplicate triples
             */
            if (i != 0 && num[i - 1] == num[i]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; ++j) {
                /**
                 * if remove the condition <code>j != i + 1</code>, 
                 * to test data [0, 0, 0], it will give a wrong answer.
                 */
                if (j != i + 1 && num[j - 1] == num[j]) {
                    continue;
                }
                int target = 0 - num[i] - num[j];
                if (target < num[j + 1] || target > num[n - 1]) {
                    continue;
                }
                int low = j + 1;
                int high = n - 1;
                int mid = (low + high) / 2;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (num[mid] == target) {
                        ArrayList<Integer> token = new ArrayList<Integer>();
                        token.add(num[i]);
                        token.add(num[j]);
                        token.add(num[mid]);
                        res.add(token);
                        break;
                    } else if (num[mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] num = null;
    }
}
