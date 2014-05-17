public class RomanToInteger {
    public int romanToInt(String s) {
        int num = 0;
        if (s == null || s.length() == 0) {
            return num;
        }

        int len = s.length();
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        for (int i = 0; i < len - 1; ++i) {
            char v = s.charAt(i);
            char w = s.charAt(i + 1);
            if (values[v] < values[w]) {
                num -= values[v];
            } else {
                num += values[v];
            }
        }
        num += values[s.charAt(len - 1)];
        return num;
    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInt("MDCVI"));
        System.out.println(solution.romanToInt("XLIX"));
    }
}
