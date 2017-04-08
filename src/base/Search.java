package base;

/**
 * @author scolphew
 */
public class Search {

    /**
     * 二分查找
     */
    public static int search(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int lower_bound(int[] nums, int key) {
        return lower_bound(nums, key, 0, nums.length);
    }

    public static int lower_bound(int[] nums, int key, int first, int length) {
        int half, mid;
        while (length > 0) {
            half = length >> 1;
            mid = first + half;
            if (nums[mid] < key) {
                first = mid + 1;
                length -= half + 1;
            } else {
                length = half;
            }
        }
        return first;
    }

    public static int upper_bound(int[] nums, int key) {
        return upper_bound(nums, key, 0, nums.length);
    }

    public static int upper_bound(int[] nums, int key, int first, int length) {
        while (length > 0) {
            int half = length >> 1;
            int mid = first + half;
            if (nums[mid] > key) {
                length = half;
            } else {
                first = mid + 1;
                length -= half + 1;
            }
        }
        return first;
    }


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


    public static void main(String[] args) {
        //int[] nums = new int[]{1, 1, 1, 2, 2, 2, 4, 4, 4};
        //System.out.println(lower_bound(nums, 4));
        //System.out.println(upper_bound(nums, 4));
        Print.print(KMPNext("ababa"));
        System.out.println(KMP("HAHAHA", "HAa"));
        System.out.println(subCount("HAHAHA", "HA"));
    }

}
