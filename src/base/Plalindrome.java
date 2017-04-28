package base;

public class Plalindrome {

    /**
     * 求最长回文字串
     */
    public static int manacher(String string) {
        char[] s = new char[string.length() * 2 + 1];
        for (int i = 0; i < string.length(); i++) {
            s[i * 2] = 0;
            s[i * 2 + 1] = string.charAt(i);
        }
        int[] len = new int[s.length];
        int maxlen = 0;
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
            maxlen = Math.max(maxlen, len[i]);
        }
        return maxlen - 1;
    }
}
