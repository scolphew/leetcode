package lsf.java._07_._745_PrefixandSuffixSearch;

class WordFilter {

    TrieNode trie;
    char TAG = '{';


    public WordFilter(String[] words) {
        trie = new TrieNode();

        for (int weight = 0; weight < words.length; ++weight) {
            char[] word = (words[weight] + TAG).toCharArray();
            for (int i = 0; i < word.length; i++) {
                TrieNode cur = trie;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length - 1; j++) {
                    int k = word[j % word.length] - 'a';
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    cur = cur.children[k];
                    cur.weight = weight;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        for (char letter : (suffix + TAG + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null)
                return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple", "applb"});
        wordFilter.f("a", "b");
    }

    class TrieNode {
        TrieNode[] children;
        int weight;

        public TrieNode() {
            children = new TrieNode[27]; //a-z #
            weight = 0;
        }
    }
}

