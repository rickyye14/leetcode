import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    private ArrayList<Integer> token;
    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        token = new ArrayList<Integer>();
        res = new ArrayList<ArrayList<Integer>>();
        if (S == null) {
            return res;
        }
        int n = S.length;
        if (n == 0) {
            return res;
        }
        Arrays.sort(S);
        for (int k = 0; k <= n; ++k) {
            searchSubsets(S, 0, k);
        }
        return res;
    }

    private void searchSubsets(int[] S, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(token));
            return;
        }
        int n = S.length;
        for (int i = start; i < n; ++i) {
            if (i != start && S[i - 1] == S[i]) {
                continue;
            }
            token.add(S[i]);
            searchSubsets(S, i + 1, k - 1);
            token.remove(token.size() - 1);
        }
    }
}
