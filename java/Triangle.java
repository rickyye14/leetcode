import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n; ++i) {
            List<Integer> previous = triangle.get(i - 1);
            List<Integer> current = triangle.get(i);
            current.set(0, previous.get(0) + current.get(0));
            for (int j = 1; j <= i - 1; ++j) {
                current.set(j, Math.min(previous.get(j - 1), previous.get(j)) 
                        + current.get(j));
            }
            current.set(i, previous.get(i - 1) + current.get(i));
        }
        int minIndex = 0;
        List<Integer> last = triangle.get(n - 1);
        for (int j = 1; j < last.size(); ++j) {
            if (last.get(j) < last.get(minIndex)) {
                minIndex = j;
            }
        }
        return last.get(minIndex);
    }
}
