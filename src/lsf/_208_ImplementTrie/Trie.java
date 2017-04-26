package lsf._208_ImplementTrie;

public class Trie {
    boolean isLeaves;
    Trie[] next;

    public Trie() {
        next = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie p = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.next[c - 'a'] == null) {
                p.next[c - 'a'] = new Trie();
            }
            p = p.next[c - 'a'];
        }
        p.isLeaves = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            if (t.next[word.charAt(i) - 'a'] == null) {
                return false;
            }
            t = t.next[word.charAt(i) - 'a'];
        }
        return t.isLeaves;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie t = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (t.next[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            t = t.next[prefix.charAt(i) - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("abc");
        System.out.println(t.search("abc"));
        System.out.println(t.startsWith("ab"));
        System.out.println(t.startsWith("abcd"));
    }
}
