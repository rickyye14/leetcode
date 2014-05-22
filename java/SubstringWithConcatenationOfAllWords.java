import java.util.ArrayList;
import java.util.LinkedList;

public class SubstringWithConcatenationOfAllWords {
    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int addWord(String s) {
            TrieNode ptr = root;
            for (int i = 0; i < s.length(); ++i) {
                int c = s.charAt(i) - 'a';
                if (c >= 26) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                if (ptr.children[c] == null) {
                    ptr.children[c] = new TrieNode();
                }
                ptr = ptr.children[c];
            }
            ++ptr.count;
            return ptr.count;
        }

        public int getCount(String s) {
            TrieNode ptr = root;
            for (int i = 0; i < s.length(); ++i) {
                int c = s.charAt(i) - 'a';
                if (ptr.children[c] == null) {
                    return 0;
                }
                ptr = ptr.children[c];
            }
            return ptr.count;
        }
    }

    private class TrieNode {
        private static final int CHARSET = 26;

        private TrieNode[] children;
        private int count;
        
        public TrieNode() {
            children = new TrieNode[CHARSET];
            count = 0;
        }
    }

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> indicesList = new ArrayList<Integer>();
        if (L == null) {
            return indicesList;
        }
        int n = S.length();
        int m = L.length;
        if (m == 0) {
            return indicesList;
        }
        int l = L[0].length();
        if (l == 0 || n < l) {
            return indicesList;
        }
        Trie dict = new Trie();
        for (int i = 0; i < m; ++i) {
            dict.addWord(L[i]);
        }
        int p = m * l;
        for (int k = 0; k + p <= n; ++k) {
            int start = k;
            int end = k + p;
            int i;
            Trie tempDict = new Trie();
            for (i = start; i + l <= end; i += l) {
                String token = S.substring(i, i + l);
                int maxCount = dict.getCount(token);
                if (maxCount == 0) {
                    break;
                }
                int currentCount = tempDict.addWord(token);
                if (currentCount > maxCount) {
                    break;
                }
            }
            if (i == end) {
                indicesList.add(k);
            }
        }
        return indicesList;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords solution 
            = new SubstringWithConcatenationOfAllWords();
        String S = null;
        String[] L = null;

        S = "barfoothefoobarman";
        L = new String[] {"foo", "bar"};
        for (Integer it : solution.findSubstring(S, L)) {
            System.out.printf("%4d", it);
        }
        System.out.println();

        S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        L = new String[] {"fooo","barr","wing","ding","wing"};
        for (Integer it : solution.findSubstring(S, L)) {
            System.out.printf("%4d", it);
        }
        System.out.println();
    }
}
