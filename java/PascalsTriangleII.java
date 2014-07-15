import java.util.ArrayList;

public class PascalsTriangleII {
    public ArrayList<Integer> getRow(int n) {
        if (n < 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> prev = null;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        for (int i = 1; i <= n; ++i) {
            prev = curr;
            curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 1; j < i; ++j) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
        }
        return curr;
    }
}
