package lsf.java._03_._395_LongestSubstringwithAtLeastKRepeatingCharacters;

public class Solution2 {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k < 2)
            return s.length();
        int[] counter = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs)
            counter[c - 'a']++;
        int start = 0, end = 0, rs = 0;
        while (end < cs.length && counter[cs[end] - 'a'] >= k)
            end++;
        if (end == cs.length)
            return cs.length;
        while (end < cs.length) {
            while (end < cs.length && counter[cs[end] - 'a'] >= k)
                end++;
            rs = Math.max(rs, longestSubstring(s.substring(start, end), k));
            start = ++end;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestSubstring("aaabb", 3));
    }

}
