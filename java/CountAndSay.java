public class CountAndSay {
    public String itoa(int n) {
        assert(n >= 0);
        if (n == 0) {
            return "0";
        }
        StringBuilder strBuilder = new StringBuilder();
        while (n != 0) {
            strBuilder.append(n % 10);
            n /= 10;
        }
        return strBuilder.reverse().toString();
    }

    public String countAndSay(int n) {
        String prev = "1";
        StringBuilder current = new StringBuilder("1");
        for (int i = 0; i < n - 1; ++i) {
            int len = prev.length();
            current = new StringBuilder();
            for (int start = 0; start < len; ++start) {
                int end = start;
                for ( ; end < len && prev.charAt(start) == prev.charAt(end); ++end) {
                    ;
                }
                int m = end - start;
                current.append(itoa(m));
                current.append(prev.charAt(start));
                start = end - 1;
            }
            prev = current.toString();
        }
        return current.toString();
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(5));
    }
}
