package lsf._409_LongestPalindrome;

public class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray())
            map[c]++;
        int ans = 0;
        boolean flag = false;
        for (int i : map) {
            if (i % 2 == 0)
                ans += i;
            else {
                ans += i - 1;
                flag = true;
            }
        }
        return ans + (flag ? 1 : 0);
    }
}
