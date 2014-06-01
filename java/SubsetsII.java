import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    private ArrayList<Integer> token;
    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        token = new ArrayList<Integer>();
        res = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return res;
        }
        int n = num.length;
        Arrays.sort(num);
        for (int k = 0; k <= n; ++k) {
            searchSubsets(num, 0, k);
        }
        return res;
    }

    private void searchSubsets(int[] num, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(token));
            return;
        }
        int n = num.length;
        for (int i = start; i < n; ++i) {
            if (i != start && num[i - 1] == num[i]) {
                continue;
            }
            token.add(num[i]);
            searchSubsets(num, i + 1, k - 1);
            token.remove(token.size() - 1);
        }
    }
}
