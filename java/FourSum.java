/**
 * Good problem.
 * First, we enumerate the number pairs and store pair sum and pair using 
 * HashMap. Then, we enumerate the indexes of <t>a</t> and <t>b</t>, and get 
 * their sum and the key (<code>key = target - num[i] - num[j]</code>). Now, we
 * can obtain all the pairs whose sum is key.
 * The tricky details are to avoid the duplicate quadruplets.
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FourSum {
    private class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return res;
        }
        int n = num.length;
        if (n < 4) {
            return res;
        }
        Arrays.sort(num);
        Map<Integer, ArrayList<Pair>> map = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < n - 1; ++i) {
            // do not add restrictions to i
            for (int j = i + 1; j < n; ++j) {
                // make sure that the value of num[j] won't not appear again
                if (j != i + 1 && num[j - 1] == num[j]) {
                    continue;
                }
                int key = num[i] + num[j];
                if (map.get(key) == null) {
                    map.put(key, new ArrayList<Pair>());
                }
                map.get(key).add(new Pair(i, j));
            }
        }
        for (int i = 0; i < n - 3; ++i) {
            if (i != 0 && num[i - 1] == num[i]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j != i + 1 && num[j - 1] == num[j]) {
                    continue;
                }
                int key = target - num[i] - num[j];
                ArrayList<Pair> pairList = map.get(key);
                if (pairList == null) {
                    continue;
                }
                int u;
                int v;
                // avoid the duplicate quadruplets
                for (u = 0; u < pairList.size() && pairList.get(u).first <= j; ++u) {
                    ;
                }
                for (v = u; v < pairList.size(); ++v) {
                    int k = pairList.get(v).first;
                    int l = pairList.get(v).second;
                    // make sure that the value of num[k] won't appear again
                    if (v != u && num[pairList.get(v - 1).first] == num[k]) {
                        continue;
                    }
                    ArrayList<Integer> token = new ArrayList<Integer>();
                    token.add(num[i]);
                    token.add(num[j]);
                    token.add(num[k]);
                    token.add(num[l]);
                    res.add(token);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] num = null;

        num = new int[] {0, 0, 0, 0};
        solution.fourSum(num, 0);
    }
}
