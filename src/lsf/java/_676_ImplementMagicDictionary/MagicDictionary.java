package lsf.java._676_ImplementMagicDictionary;

import java.util.*;

public class MagicDictionary {

    Map<String, Integer> count;
    Set<String> words;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        count = new HashMap<>();
        words = new HashSet<>();
    }

    private List<String> generalizedNeighbors(String word) {
        ArrayList<String> list = new ArrayList();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            char tmp = chars[i];
            chars[i] = '*';
            String magic = new String(chars);
            list.add(magic);
            chars[i] = tmp;
        }
        return list;
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            words.add(word);
            for (String magic : generalizedNeighbors(word)) {
                count.put(magic, count.getOrDefault(magic, 0) + 1);
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        for (String s : generalizedNeighbors(word)) {
            int c = count.getOrDefault(s, 0);
            if (c > 1 || (c == 1 && !words.contains(s)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{"hello"});

        System.out.println(md.count);
        System.out.println(md.search("hhllo"));
    }

}
