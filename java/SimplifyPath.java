public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder simplePath = new StringBuilder();
        String[] tokens = path.split("/");
        int n = tokens.length;
        int top = 0;
        String[] stack = new String[n];
        for (int i = 0; i < n; ++i) {
            String s = tokens[i];
            if (s.length() == 0 || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                top = Math.max(0, top - 1);
            } else {
                stack[top++] = s;
            }
        }
        for (int i = 0; i < top; ++i) {
            simplePath.append("/" + stack[i]);
        }
        if (top == 0) {
            simplePath.append("/");
        }
        return simplePath.toString();
    }
}
