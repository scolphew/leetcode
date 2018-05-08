package lsf.java._005_LongestPalindromicSubstring;

public class Solution2 {
    public String longestPalindrome(String string) {
        char[] s = new char[string.length() * 2 + 1];
        for (int i = 0; i < string.length(); i++) {
            s[i * 2] = 0;
            s[i * 2 + 1] = string.charAt(i);
        }
        int[] len = new int[s.length];
        int maxlen = 0;
        int index = 0;
        int pos = 0, maxRight = 0;
        for (int i = 0; i < s.length; i++) {
            if (i < maxRight) {
                len[i] = Math.min(maxRight - i, len[2 * pos - i]);
            } else {
                len[i] = 1;
            }
            while (i - len[i] >= 0 && i + len[i] < s.length && s[i - len[i]] == s[i + len[i]]) {
                len[i]++;
            }
            if (len[i] + i - 1 > maxRight) {
                pos = i;
                maxRight = i + len[i] - 1;
            }
            if (len[i] > maxlen) {
                maxlen = len[i];
                index = i - len[i] + 2;
            }
        }
        System.out.printf("%d %d \n", index / 2, maxlen - 1);
        return string.substring(index / 2, index / 2 + maxlen - 1);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.longestPalindrome("aba"));
        System.out.println(s.longestPalindrome("aa"));
        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("aaaa"));
    }

}
