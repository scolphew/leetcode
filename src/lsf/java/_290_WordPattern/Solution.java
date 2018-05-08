package lsf.java._290_WordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.wordPattern("abba", "dog cat cat dog");
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println(map.put(1, 1));
        System.out.println(map.put(1, 2));
        System.out.println(map);
    }
}
