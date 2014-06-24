import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class WordLadder {
    private class Status {
        private String word;
        private int step;

        public Status(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            return 0;
        }
        if (start.length() != end.length()) {
            return 0;
        }
        dict.remove(start);
        dict.add(end);
        Queue<Status> Q = new LinkedList<Status>();
        Q.add(new Status(start, 0));
        while (!Q.isEmpty()) {
            Status curr = Q.poll();
            if (curr.word.equals(end)) {
                return curr.step + 1;
            }
            StringBuilder token = new StringBuilder(curr.word);
            int n = token.length();
            for (int i = 0; i < n; ++i) {
                char cc = token.charAt(i);
                for (int j = 0; j < 26; ++j) {
                    char nc = (char) (j + 'a');
                    if (nc == cc) {
                        continue;
                    }
                    token.setCharAt(i, nc);
                    String word = token.toString();
                    if (dict.contains(word)) {
                        dict.remove(word);
                        Q.add(new Status(word, curr.step + 1));
                    }
                }
                token.setCharAt(i, cc);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder solver   = new WordLadder();
        String start        = null;
        String end          = null;
        Set<String> dict    = null;
        String[] words      = null;

        start = "hit";
        end = "cog";
        words = new String[] {"hot", "dot", "dog", "lot", "log"};
        dict = new TreeSet<String>();
        for (int i = 0; i < words.length; ++i) {
            dict.add(words[i]);
        }
        System.out.println(solver.ladderLength(start, end, dict));
    }
}
