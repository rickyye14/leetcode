public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        int n = s.length();
        if (n == 0) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        char[] chStack = new char[n];
        int top = 0;
        chStack[top++] = s.charAt(0);
        for (int i = 1; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                chStack[top++] = ch;
            } else {
                if (ch == ')') {
                    if (chStack[top - 1] != '(') {
                        break;
                    } else {
                        --top;
                    }
                } else if (ch == '}') {
                    if (chStack[top - 1] != '{') {
                        break;
                    } else {
                        --top;
                    }
                } else {
                    if (chStack[top - 1] != '[') {
                        break;
                    } else {
                        --top;
                    }
                }
            }
        }
        return (top == 0);
    }
}
