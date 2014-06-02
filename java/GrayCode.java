import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> codes = new ArrayList<Integer>();
        if (n <= 0) {
            codes.add(0);
            return codes;
        }
        codes.add(0);
        codes.add(1);
        for (int i = 1; i < n; ++i) {
            for (int j = (1 << i) - 1; j >= 0; --j) {
                codes.add((1 << i) + codes.get(j));
            }
        }
        return codes;
    }
}
