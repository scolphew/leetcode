package lsf.java._06_._696_CountBinarySubstrings;

public class Solution {

    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
     * 并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     *
     * @param s
     * @return
     */

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int p = 0;
        int t = 1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while ((i + 1 < s.length()) && (chars[i] == chars[i + 1])) {
                i++;
                t++;
            }
            ans += Math.min(p, t);
            p = t;
            t = 1;
        }
        return ans;
    }

    public int countBinarySubstrings2(String s) {
        char[] a = s.toCharArray();
        int current = 1, pre = 0, ans = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                current++;
            } else {
                pre = current;
                current = 1;
            }
            if (pre >= current) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.countBinarySubstrings("00110"));
    }

}
