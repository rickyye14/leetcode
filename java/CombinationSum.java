import java.util.Arrays;
import java.util.ArrayList;

public class CombinationSum {
    ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (target <= 0) {
            return res;
        }
        int n = candidates.length;
        ArrayList<ArrayList<ArrayList<Integer>>> dp 
            = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i <= target; ++i) {
            dp.add(new ArrayList<ArrayList<Integer>>());
        }
        Arrays.sort(candidates);
        for (int i = 0; i < n; ++i) {
            if (i != 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            int c = candidates[i];
            if (c > target) {
                break;
            }
            ArrayList<Integer> token = new ArrayList<Integer>();
            token.add(c);
            dp.get(c).add(token);
        }
        for (int i = 0; i < n; ++i) {
            if (i != 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            int c = candidates[i];
            if (c > target) {
                break;
            }
            int start = 1;
            int end = target - c;
            for (int j = start; j <= end; ++j) {
                ArrayList<ArrayList<Integer>> temp 
                    = new ArrayList<ArrayList<Integer>>();
                for (int k = 0; k < dp.get(j).size(); ++k) {
                    temp.add(new ArrayList<Integer>(dp.get(j).get(k)));
                }
                for (int k = 0; k < temp.size(); ++k) {
                    int m = temp.get(k).size();
                    if (temp.get(k).get(m - 1) > c) {
                        continue;
                    }
                    temp.get(k).add(c);
                    dp.get(j + c).add(temp.get(k));
                }
            }
        }
        return dp.get(target);
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
        CombinationSum solver = new CombinationSum();
        int[] candidates = null;
        ArrayList<ArrayList<Integer>> res = null;

        candidates = new int[] {2, 3, 6, 7};
        solver.display(solver.combinationSum(candidates, 7));
    }
}
