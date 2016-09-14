package lsf._027_KMP;

import lsf._000_base.Print;

/**
 * @author scolphew
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int len_sub = needle.length();
        if (len - len_sub < 0) {
            return -1;
        }
        if (len == 0 || len_sub == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < len) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == len_sub - 1) {
                    return i - len_sub + 1;
                }
                ++i;
                ++j;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
        }
        return -1;
    }

    int[] getNext(String sub) {
        int[] next = new int[sub.length()];
        char[] c = sub.toCharArray();
        int len = sub.length();
        int i, j;
        next[0] = 0;
        for (j = 1, i = 0; j < len; j++) {
            while (i > 0 && c[j] != c[i]) {
                i = next[i - 1];
            }
            if (c[j] == c[i]) {
                i++;
            }
            next[j] = i;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //int i = s.strStr("mississippi", "issip");
        //System.out.println(i);

        int[] j = s.getNext("abcdabd");
        Print.print(j);


    }

}
