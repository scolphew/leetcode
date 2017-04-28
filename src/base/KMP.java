package base;

public class KMP {
    /**
     * 求字串首次出现位置
     */
    public static int KMP(String a, String pattern) {
        int[] next = KMPNext(pattern);
        int q = 0;
        int p = 0;
        while (p < a.length()) {
            if (q == -1 || a.charAt(p) == pattern.charAt(q)) {
                p++;
                q++;
            } else {
                q = next[q];
            }
            if (q == pattern.length()) {
                return p - q;
            }
        }
        return -1;
    }

    /**
     * 求字串出现次数
     */
    public static int subCount(String a, String pattern) {
        int res = 0;
        int[] next = KMPNext(pattern);
        int q = 0;
        int p = 0;
        while (p < a.length()) {
            if (q == -1 || a.charAt(p) == pattern.charAt(q)) {
                p++;
                q++;
            } else {
                q = next[q];
            }
            if (q == pattern.length()) {
                p--;
                q = next[q - 1];
                res += 1;
            }
        }
        return res;
    }

    /**
     * NEXT数组
     */
    private static int[] KMPNext(String a) {
        int l = a.length();
        int next[] = new int[l];
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < a.length() - 1) {
            if (k == -1 || a.charAt(j) == a.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;

    }


}
