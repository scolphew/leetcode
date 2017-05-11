package lsf._524_LongestWordinDictionarythroughDeleting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    char[] chars;

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        chars = s.toCharArray();
        for (String string : d) {
            if (s.length() < string.length())
                continue;
            if (foo(string))
                return string;
        }
        return "";
    }

    public boolean foo(String s) {
        int i = 0;
        for (char c : chars) {
            if (c == s.charAt(i))
                i++;
            if (i == s.length())
                break;
        }
        return i == s.length();
    }


    private boolean foo2(String p) {
        int i = 0, j = 0;
        while (i < chars.length && j < p.length()) {
            if (chars[i] == p.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("aa");
        list.add("ab");
        list.add("ba");
        list.add("caa");
        System.out.println(s.findLongestWord("aab", list));

    }

}
