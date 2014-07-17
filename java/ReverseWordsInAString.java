public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String rev = new StringBuilder(s).reverse().toString();
        StringBuilder res = new StringBuilder("");
        String token = new String("");
        int n = rev.length();
        for (int i = 0; i < n; ++i) {
            while (i < n && rev.charAt(i) == ' ') {
                ++i;
            }
            if (i == n) {
                break;
            }
            int j = i;
            while (j < n && rev.charAt(j) != ' ') {
                ++j;
            }
            int k = j;
            --j;
            StringBuilder word = new StringBuilder(rev.substring(i, k)).reverse();
            res.append(token + word);
            token = " ";
            i = k - 1;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString solver = new ReverseWordsInAString();
        String s = null;
        s = new String("the sky is blue");
        System.out.println(solver.reverseWords(s));
    }
}
