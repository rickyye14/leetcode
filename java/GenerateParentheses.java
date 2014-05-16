import java.util.ArrayList;

public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<ArrayList<String>> results 
            = new ArrayList<ArrayList<String>>();
        results.add(new ArrayList<String>());
        results.add(new ArrayList<String>());
        results.get(1).add("()");
        for (int i = 2; i <= n; ++i) {
            results.add(new ArrayList<String>());
            ArrayList<String> prev = results.get(i - 1);
            ArrayList<String> current = results.get(i);
            for (int j = 0; j < prev.size(); ++j) {
                String parenthesis = null;
                parenthesis = "()" + prev.get(j);
                if (!current.contains(parenthesis)) {
                    current.add(parenthesis);
                }
                parenthesis = "(" + prev.get(j) + ")";
                if (!current.contains(parenthesis)) {
                    current.add(parenthesis);
                }
                parenthesis = prev.get(j) + "()";
                if (!current.contains(parenthesis)) {
                    current.add(parenthesis);
                }
            }
        }
        return results.get(n);
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        solution.generateParenthesis(5);
    }
}
