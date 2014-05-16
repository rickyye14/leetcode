import java.util.ArrayList;

public class GenerateParentheses {
    ArrayList<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<String>();
        }
        ArrayList<ArrayList<String>> parethesisList 
            = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("");
        parethesisList.add(temp);
        for (int i = 1; i <= n; ++i) {
            ArrayList<String> prev = parethesisList.get(i - 1);
            ArrayList<String> current = new ArrayList<String>();
            for (int j = 0; j < prev.size(); ++j) {
                String parethesis = "(" + prev.get(j) + ")";
                if (!current.contains(parethesis)) {
                    current.add(parethesis);
                }
            }
            for (int j = 1; j < i; ++j) {
                ArrayList<String> left = parethesisList.get(j);
                ArrayList<String> right = parethesisList.get(i - j);
                for (int k = 0; k < left.size(); ++k) {
                    for (int l = 0; l < right.size(); ++l) {
                        String parethesis = left.get(k) + right.get(l);
                        if (!current.contains(parethesis)) {
                            current.add(parethesis);
                        }
                    }
                }
            }
            parethesisList.add(current);
        }
        return parethesisList.get(n);
    }

    void display(ArrayList<String> strList) {
        if (strList == null) {
            return;
        }
        for (int i = 0; i < strList.size(); ++i) {
            System.out.println(strList.get(i));
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        solution.display(solution.generateParenthesis(3));
        System.out.println();
        solution.display(solution.generateParenthesis(4));
    }
}
