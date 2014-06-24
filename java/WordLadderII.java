import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class WordLadderII {
    private LinkedList<String> path;
    private LinkedList<LinkedList<String>> paths;
    private Map<String, Integer> dp;
    private Map<String, LinkedList<String>> mark;

    public LinkedList<LinkedList<String>> findLadders(String start, String end, Set<String> dict) {
        path = new LinkedList<String>();
        paths = new LinkedList<LinkedList<String>>();

        if (start == null || end == null || dict == null) {
            return paths;
        }
        if (start.length() != end.length()) {
            return paths;
        }

        dict.remove(start);
        dict.add(end);

        dp = new HashMap<String, Integer>();
        for (String word : dict) {
            dp.put(word, 0x3f3f3f3f);
        }

        mark = new HashMap<String, LinkedList<String>>();

        Queue<String> Q = new LinkedList<String>();
        Q.add(start);
        dp.put(start, 0);
        mark.put(start, new LinkedList<String>());
        mark.get(start).add(null);

        int minSteps = 0x3f3f3f3f;
        int n = start.length();

        while (!Q.isEmpty()) {
            String curr = Q.poll();
            if (dp.get(curr) > minSteps) {
                break;
            }
            if (curr.equals(end)) {
                minSteps = dp.get(curr);
                continue;
            }
            StringBuilder token = new StringBuilder(curr);
            int currStep = dp.get(curr);
            for (int i = 0; i < n; ++i) {
                char cc = token.charAt(i);
                for (int j = 0; j < 26; ++j) {
                    char nc = (char) (j + 'a');
                    if (cc == nc) {
                        continue;
                    }
                    token.setCharAt(i, nc);
                    String next = token.toString();
                    if (dict.contains(next)) {
                        int nextStep = currStep + 1;
                        if (nextStep > dp.get(next)) {
                            continue;
                        }
                        if (nextStep < dp.get(next)) {
                            dp.put(next, nextStep);
                            mark.put(next, new LinkedList<String>());
                            Q.add(next);
                        }
                        mark.get(next).add(curr);
                    }
                }
                token.setCharAt(i, cc);
            }
        }

        if (!mark.containsKey(end) || mark.get(end).isEmpty()) {
            return paths;
        }

        searchPath(end);

        return paths;
    }
    
    private void searchPath(String curr) {
        if (curr == null) {
            LinkedList<String> temp = new LinkedList<String>(path);
            Collections.reverse(temp);
            paths.add(temp);
            return;
        }
        path.add(curr);
        for (String next : mark.get(curr)) {
            searchPath(next);
        }
        path.removeLast();
    }
}
