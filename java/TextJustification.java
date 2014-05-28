import java.util.ArrayList;

public class TextJustification {
    private String generateSpaces(int n) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if (words == null) {
            return res;
        }
        int n = words.length;
        if (n == 0) {
            return res;
        }
        for (int i = 0; i < n; ++i) {
            int j = i;
            int len = 0;
            for ( ; j < n; ++j) {
                if (len + words[j].length() + j - i > L) {
                    break;
                }
                len += words[j].length();
            }
            if (i == j) {
                int m = words[i].length();
                res.add(words[i].substring(0, L));
                words[i] = new String(words[i].substring(L, m));
            } else if (i + 1 == j) {
                int m = words[i].length();
                res.add(words[i] + generateSpaces(L - m));
            } else {
                StringBuilder line = new StringBuilder();
                line.append(words[i]);
                int p = j - i - 1;
                int spaces = L - len;
                int slot = spaces / p;
                int token = spaces % p;
                for (int k = i + 1; k < j; ++k) {
                    if (j == n) {
                        line.append(" ");
                    } else {
                        if (token-- > 0) {
                            line.append(generateSpaces(slot + 1));
                        } else {
                            line.append(generateSpaces(slot));
                        }
                    }
                    line.append(words[k]);
                }
                if (j == n) {
                    line.append(generateSpaces(L - len - p));
                }
                res.add(line.toString());
            }
            i = j - 1;
        }
        return res;
    }

    public void display(ArrayList<String> res) {
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        TextJustification solver = new TextJustification();
        String[] words = null;
        words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        solver.display(solver.fullJustify(words, 16));
        words = new String[] {""};
        solver.display(solver.fullJustify(words, 2));
    }
}
