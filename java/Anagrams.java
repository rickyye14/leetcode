import java.util.ArrayList;

public class Anagrams {
    private class TrieNode {
        private TrieNode[] children;
        private ArrayList<Integer> indices;

        public TrieNode() {
            children = new TrieNode[26];
            indices = new ArrayList<Integer>();
        }
    }

    private String sortWord(String word) {
        StringBuilder strBuilder = new StringBuilder();
        int[] buckets = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            ++buckets[c];
        }
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < buckets[i]; ++j) {
                strBuilder.append((char)('a' + i));
            }
        }
        return strBuilder.toString();
    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null) {
            return res;
        }
        int n = strs.length;
        if (n < 2) {
            return res;
        }
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; ++i) {
            String word = sortWord(strs[i]);
            TrieNode ptr = root;
            int m = word.length();
            for (int j = 0; j < m; ++j) {
                int c = word.charAt(j) - 'a';
                if (ptr.children[c] == null) {
                    ptr.children[c] = new TrieNode();
                }
                ptr = ptr.children[c];
            }
            if (ptr.indices.size() == 1) {
                res.add(strs[ptr.indices.get(0)]);
            }
            ptr.indices.add(i);
            if (ptr.indices.size() > 1) {
                res.add(strs[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Anagrams solver = new Anagrams();
        String[] strs = new String[] {"cat","rye","aye","dog", "god","cud","cat","old","fop","bra"};

        for (String s : solver.anagrams(strs)) {
            System.out.println(s);
        }

        System.out.println();
    }
}
