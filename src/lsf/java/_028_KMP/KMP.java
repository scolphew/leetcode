package lsf.java._028_KMP;

public class KMP {

    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int len_sub = needle.length();
        if (len - len_sub < 0) {
            return -1;
        }
        if (len == 0 || len_sub == 0) {
            return 0;
        }

        char[] sub = needle.toCharArray();
        char[] s = haystack.toCharArray();
        int[] next = getNext(sub);
        int i = 0, j = 0;
        while (j < len) {
            if (i == -1 || s[j] == sub[i]) {
                ++i;
                ++j;
            } else {
                i = next[i];
            }
            if (i == len_sub) {
                return j - i;
            }
        }
        return -1;
    }


    public int[] getNext(char[] s) {
        int next[] = new int[s.length];
        next[0] = -1;
        int j = 0, i = -1;
        while (j < s.length - 1) {
            if (i == -1 || s[i] == s[j]) {
                next[++j] = ++i;
            } else {
                i = next[i];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        System.out.println(new KMP().strStr("abaabcaba", "abcaba"));
        System.out.println(new KMP().strStr("aabaaabaaac", "aabaaac"));
    }
}
