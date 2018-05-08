package lsf.java._214_ShortestPalindrome;

import base.Print;

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


    public String shortestPalindrome2(String s) {
        if (s.length() <= 1)
            return s;
        String newS = s + "#" + new StringBuilder(s).reverse().toString();
        int[] position = getNext(newS.toCharArray());
        Print.print(position);
        return new StringBuilder(s.substring(position[position.length - 1])).reverse().toString() + s;
    }

    public int[] getNext(char[] s) {
        int next[] = new int[s.length];
        next[0] = 0;
        for (int j = 1, i = 0; j < s.length; j++) {
            while (i > 0 && s[i] != s[j]) {
                i = next[i - 1];
            }
            if (s[i] == s[j]) {
                i++;
            }
            next[j] = i;
        }
        return next;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome2("abad"));
        System.out.println(new Solution().shortestPalindrome2("aaaaa"));

    }
}
