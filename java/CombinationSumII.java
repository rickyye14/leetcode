import java.util.Arrays;
import java.util.ArrayList;

public class CombinationSumII {
    private ArrayList<ArrayList<Integer>> results;
    private ArrayList<Integer> token;

    private void searchCombination(int[] num, int target, int start) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(token));
            return;
        }
        int prev = -1;
        for (int i = start; i < num.length; ++i) {
            if (num[i] > target) {
                break;
            }
            if (num[i] == prev) {
                continue;
            }
            token.add(num[i]);
            searchCombination(num, target - num[i], i + 1);
            token.remove(token.size() - 1);
            prev = num[i];
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        results = new ArrayList<ArrayList<Integer>>();
        token = new ArrayList<Integer>();
        Arrays.sort(num);
        searchCombination(num, target, 0);
        return results;
    }

    public void display(ArrayList<ArrayList<Integer>> res) {
        for (ArrayList<Integer> token : res) {
            for (Integer a : token) {
                System.out.printf("%4d", a);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CombinationSumII solver = new CombinationSumII();
        int[] num = null;

        num = new int[] {10, 1, 2, 7, 6, 1, 5};
        solver.display(solver.combinationSum2(num, 8));

        num = new int[] {2, 2, 2};
        solver.display(solver.combinationSum2(num, 4));
    }
}
