package lsf._211_AddandSearchWordDatastructuredesign;

public class WordDictionary {

    boolean isLeaves;
    WordDictionary[] next;

    public WordDictionary() {
        next = new WordDictionary[26];
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        WordDictionary p = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.next[index] == null)
                p.next[index] = new WordDictionary();
            p = p.next[index];
        }
        p.isLeaves = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, 0, this);
    }

    public boolean search(String word, int start, WordDictionary p) {
        for (int i = start; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (p.next[j] != null && search(word, i + 1, p.next[j]))
                        return true;
                }
                return false;
            } else {
                if (p.next[word.charAt(i) - 'a'] == null)
                    return false;
                p = p.next[word.charAt(i) - 'a'];
            }
        }
        return p.isLeaves;
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("a");
        w.addWord("ab");
        System.out.println(w.search("a"));
    }
}
