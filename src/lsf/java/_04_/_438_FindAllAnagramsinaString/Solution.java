package lsf.java._04_._438_FindAllAnagramsinaString;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (map[s.charAt(right++) - 'a']-- >= 1)
                count--;
            if (count == 0)
                ans.add(left);
            if (right - left == p.length() && map[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
    }
}
