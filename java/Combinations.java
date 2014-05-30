import java.util.ArrayList;

public class Combinations {
    private ArrayList<ArrayList<Integer>> res;
    private ArrayList<Integer> token;

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        res = new ArrayList<ArrayList<Integer>>();
        token = new ArrayList<Integer>();
        if (k <= 0 || k > n) {
            return res;
        }
        searchCombinations(n, 0, k);
        return res;
    }

    private void searchCombinations(int n, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(token));
            return;
        }
        int end = n - k;
        for (int i = start; i <= end; ++i) {
            token.add(i + 1);
            searchCombinations(n, i + 1, k - 1);
            token.remove(token.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations sovler = new Combinations();
    }
}
