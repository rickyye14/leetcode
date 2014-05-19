public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int[] stack = new int[n];
        int top = 0;
        int[] dp = new int[n + 1];
        if (s.charAt(0) == '(') {
            stack[top++] = 1;
        }
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '(') {
                stack[top++] = i + 1;
            } else {
                if (top != 0) {
                    int len = i - (stack[top - 1] - 1) + 1;
                    dp[i + 1] = dp[stack[top - 1] - 1] + len;
                    --top;
                }
            }
        }
        int longest = 0;
        for (int i = 0; i <= n; ++i) {
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        String s = null;

        s = "()(()";
        System.out.println(solution.longestValidParentheses(s));

        s = ")()())";
        System.out.println(solution.longestValidParentheses(s));

        s = "(()";
        System.out.println(solution.longestValidParentheses(s));
    }
}
