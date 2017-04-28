package lsf._214_ShortestPalindrome;

public class Solution {
    /**
     * 在字符串之前补充，使之成为回文串
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length;
        while (--i >= 0)
            if (chars[i] == chars[0] && foo(chars, 0, i))
                break;

        StringBuilder sb = new StringBuilder();
        for (int j = chars.length - 1; j > i; j--) {
            sb.append(chars[j]);
        }
        sb.append(s);
        return sb.toString();

    }

    public boolean foo(char[] chars, int l, int r) {
        while (l <= r && chars[l] == chars[r]) {
            l++;
            r--;
        }
        return l > r;
    }

    public boolean foo(char[] chars) {
        return foo(chars, 0, chars.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("abc"));
        System.out.println(new Solution().shortestPalindrome("a"));
        System.out.println(new Solution().shortestPalindrome("ab"));
        System.out.println(new Solution().shortestPalindrome(""));
    }
}
