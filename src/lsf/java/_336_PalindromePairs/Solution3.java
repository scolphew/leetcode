package lsf.java._336_PalindromePairs;

import java.util.*;

public class Solution3 {
    class Trie {
        Trie[] children;
        int index;
        List<Integer> palindromes;

        Trie() {
            this.children = new Trie[26];
            this.index = -1;
            palindromes = new ArrayList<>();
        }

    }

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();
        Trie root = new Trie();
        for (int index = 0; index < words.length; index++) {
            insert(words[index], index, root);
        }

        for (int index = 0; index < words.length; index++) {
            search(words[index], index, root, res);
        }

        return res;
    }

    private void insert(String word, int i, Trie node) {

        for (int index = 0; index < word.length(); index++) {
            int childIndex = word.charAt(index) - 'a';
            if (node.children[childIndex] == null) {
                node.children[childIndex] = new Trie();
            }
            if (isPalindrome(word, index, word.length() - 1)) {
                node.palindromes.add(i);
            }
            node = node.children[childIndex];
        }
        node.palindromes.add(i);
        node.index = i;
    }

    private void search(String word, int i, Trie node, List<List<Integer>> res) {

        for (int index = word.length() - 1; index >= 0; index--) {
            int childIndex = word.charAt(index) - 'a';
            if (node == null) { //means not match
                return;
            }
            if (node.index >= 0) {//means a word exists
                if (isPalindrome(word, 0, index)) {
                    res.add(Arrays.asList(node.index, i));
                }
            }
            node = node.children[childIndex];
        }
        if (node == null) return;
        for (Integer palindrome : node.palindromes) {
            if (palindrome != i) {
                res.add(Arrays.asList(palindrome, i));
            }
        }

    }

    private boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().palindromePairs(new String[]{
                "lls", "sssll"
        }));
    }


}
