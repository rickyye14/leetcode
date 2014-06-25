import java.util.Set;

public class WordBreak {
    private class TrieNode {
        private TrieNode[] next;
        private int flag;

        public TrieNode() {
            next = new TrieNode[26];
            flag = 0;
        }
    }

    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void add(String word) {
            TrieNode ptr = root;
            int n = word.length();
            for (int i = 0; i < n; ++i) {
                int c = word.charAt(i) - 'a';
                if (ptr.next[c] == null) {
                    ptr.next[c] = new TrieNode();
                }
                ptr = ptr.next[c];
            }
            ++ptr.flag;
        }
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        Trie trie = new Trie();
        for (String word : dict) {
            trie.add(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            if (!dp[i - 1]) {
                continue;
            }
            TrieNode ptr = trie.root;
            for (int j = i - 1; j < n; ++j) {
                int c = s.charAt(j) - 'a';
                if (ptr.next[c] == null) {
                    break;
                }
                ptr = ptr.next[c];
                if (ptr.flag != 0) {
                    dp[j + 1] = true;
                }
            }
        }
        return dp[n];
    }
}
