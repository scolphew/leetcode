package lsf.java._04_._409_LongestPalindrome;

public class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray())
            map[c]++;
        int ans = 0;
        for (int i : map) {
            if (i % 2 == 0)
                ans += i;
            else {
                ans += i - 1;
            }
        }
        return ans + (s.length()>ans ? 1 : 0);
    }
}
