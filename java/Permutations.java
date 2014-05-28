import java.util.ArrayList;

public class Permutations {
    private ArrayList<Integer> next(ArrayList<Integer> current) {
        ArrayList<Integer> next 
            = new ArrayList<Integer>(current);
        int n = current.size();
        int i = n - 1;
        for ( ; i > 0; --i) {
            if (next.get(i - 1) < next.get(i)) {
                int j = n - 1;
                for ( ; j > i; --j) {
                    if (next.get(j) > next.get(i - 1)) {
                        break;
                    }
                }
                int temp = next.get(i - 1);
                next.set(i - 1, next.get(j));
                next.set(j, temp);
                break;
            }
        }
        int j = n - 1;
        for ( ; i < j; ++i, --j) {
            int temp = next.get(i);
            next.set(i, next.get(j));
            next.set(j, temp);
        }
        return next;
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res 
            = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return res;
        }
        int n = num.length;
        if (n == 0) {
            return res;
        }
        ArrayList<Integer> current = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            current.add(num[i]);
        }
        int m = 1;
        for (int i = 1; i <= n; ++i) {
            m *= i;
        }
        res.add(current);
        for (int i = 0; i < m - 1; ++i) {
            ArrayList<Integer> next = next(current);
            res.add(next);
            current = next;
        }
        return res;
    }

    private void display(ArrayList<ArrayList<Integer>> res) {
        for (ArrayList<Integer> token : res) {
            for (Integer x : token) {
                System.out.printf("%4d", x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();
        int[] num = null;

        num = new int[] {1, 2, 3};
        solver.display(solver.permute(num));
    }
}
