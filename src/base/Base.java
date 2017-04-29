package base;

import lsf._215_KthLargestElementinanArray.Solution;

public class Base {

    /**
     * 最大公约数，
     * @param a 非零
     * @param b 非零
     * @return
     */
    public static int gcd(int a, int b) {
        while (b != 1) {
            if (a % b == 0) return b;
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    /**
     * 最大公约数，若有一个为0，返回另一个
     * @param a 可为零
     * @param b 可为零
     * @return
     */
    public static int gcd2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(a, b);
    }


    /**
     * 寻找数组中第i大的数
     *
     * @param nums
     * @param i
     * @return
     */
    public static int findNTh(int[] nums, int i) {
        return new Solution().findKthLargest(nums, i);
    }
}
