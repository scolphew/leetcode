package lsf.java._06_._648_ReplaceWords;

import java.util.List;

public class Solution {
    class Trie {
        Trie[] children;
        String word;

        Trie() {
            children = new Trie[26];
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            Trie cur = trie;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new Trie();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        StringBuilder ans = new StringBuilder();

        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            Trie cur = trie;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.word != null) {
                    // 没这个词，最短前缀
                    break;
                }
                cur = cur.children[c - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}
