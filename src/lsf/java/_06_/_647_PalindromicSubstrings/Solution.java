package lsf.java._06_._647_PalindromicSubstrings;

/**
 * 求字符串中回文的数量
 *
 * 利用最长回文字串的算法，求出所有位置的最长回文，在加起来
 */
public class Solution {
    public int countSubstrings(String s) {
        char[] chars = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            chars[2 * i] = 0;
            chars[2 * i + 1] = s.charAt(i);
        }
        int[] len = new int[chars.length];
        int pos = 0, maxRight = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < maxRight) {
                len[i] = Math.min(maxRight - i, len[2 * pos - i]);
            } else {
                len[i] = 1;
            }

            while (i - len[i] >= 0 && i + len[i] < chars.length && chars[i - len[i]] == chars[i + len[i]]) {
                len[i]++;
            }

            if (len[i] + i - 1 > maxRight) {
                pos = i;
                maxRight = len[i] + i - 1;
            }
        }
        for (int i : len)
            ans += i / 2;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("aaa"));
    }
}
