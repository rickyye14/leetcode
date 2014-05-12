import java.util.ArrayList;
import java.util.Collections;

public class ZigZagConversion {
    private class CharPosition implements Comparable<CharPosition> {
        private char ch;
        private int x;
        private int y;

        public CharPosition(char ch, int x, int y) {
            this.ch = ch;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(CharPosition that) {
            if (this.x != that.x) {
                return this.x - that.x;
            }
            return this.y - that.y;
        }
    }

    public String convert(String s, int nRows) {
        if (s == null) {
            return null;
        }
        int n = s.length();
        if (n == 0) {
            return s;
        }
        ArrayList<CharPosition> cpList = new ArrayList<CharPosition>();
        StringBuilder builder = new StringBuilder();

        for (int j = 0, k = 0; k < n; ++j) {
            if (j % 2 == 0) {
                for (int i = 0; i < nRows && k < n; ++i, ++k) {
                    cpList.add(new CharPosition(s.charAt(k), i, j));
                }
            } else {
                for (int i = nRows - 2; i > 0 && k < n; --i, ++k) {
                    cpList.add(new CharPosition(s.charAt(k), i, j));
                }
            }
        }
        Collections.sort(cpList);
        for (int i = 0; i < n; ++i) {
            builder.append(cpList.get(i).ch);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion solution = new ZigZagConversion();
        String s;
        s = "ABC";
        System.out.println(solution.convert(s, 2));

        s = "ABCD";
        System.out.println(solution.convert(s, 2));

        s = "PAYPALISHIRING";
        System.out.println(solution.convert(s, 3));

        s = "PAYPALISHIRING";
        System.out.println(solution.convert(s, 4));
    }
}
