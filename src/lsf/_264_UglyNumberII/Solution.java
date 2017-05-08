package lsf._264_UglyNumberII;


public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int m2 = ugly[i2] * 2;
            int m3 = ugly[i3] * 3;
            int m5 = ugly[i5] * 5;

            int tmp = Math.min(m2, Math.min(m3, m5));
            if (tmp == m2) i2++;
            if (tmp == m3) i3++;
            if (tmp == m5) i5++;
            ugly[i] = tmp;
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
