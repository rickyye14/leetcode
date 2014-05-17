import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
    private StringBuilder strBuilder;
    private ArrayList<String> ansList;
    private String[] codes = new String[] {"", "", "abc", "def", "ghi", 
        "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void searchCombinations(String digits, int ptr) {
        if (ptr >= digits.length()) {
            ansList.add(strBuilder.toString());
            return;
        }
        int num = digits.charAt(ptr) - '0';
        int n = codes[num].length();
        for (int i = 0; i < n; ++i) {
            strBuilder.append(codes[num].charAt(i));
            searchCombinations(digits, ptr + 1);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }

    public ArrayList<String> letterCombinations(String digits) {
        strBuilder = new StringBuilder();
        ansList = new ArrayList<String>();
        if (digits == null) {
            return ansList;
        }
        searchCombinations(digits, 0);
        return ansList;
    }
}
