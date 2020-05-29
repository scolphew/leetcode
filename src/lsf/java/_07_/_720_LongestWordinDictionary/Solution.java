package lsf.java._07_._720_LongestWordinDictionary;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> s = new HashSet<>();
        String ans = "";
        for (String word : words) {
            if (word.length() == 1 || s.contains(word.substring(0, word.length() - 1))) {
                s.add(word);
                if (word.length() > ans.length())
                    ans = word;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestWord(new String[]{"world", "w","worl", "wo", "wor"}));
    }
}
