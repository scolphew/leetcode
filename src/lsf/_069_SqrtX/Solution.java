package lsf._069_SqrtX;

/**
 * 整形开房，返回整数部分
 *
 * @author scolphew
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 1;
        int right = x - 1;
        while (left < right) {
            int mid = (left + right +1) >>> 1;
            if (x / mid < mid)
                right = mid - 1;
            else {
                left = mid ;
            }
        }
        return left;
    }

    int leetcode(int x) {
        if (x <= 1) return x;
        int l = 1, r = x - 1;
        while (l < r) {
            int m = l + ((r - l + 1) >> 1);
            if (m > x / m) r = m - 1;
            else l = m;
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(10));
        System.out.println(s.leetcode(100));
    }
}
