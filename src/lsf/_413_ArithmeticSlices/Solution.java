package lsf._413_ArithmeticSlices;

public class Solution {
    /**
     * 求数组A的子数组中有多少个等差数列
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0, i = 0;
        while (i < A.length - 1) {
            int start = i;
            int d = A[i + 1] - A[i];
            i++;
            while (i < A.length && A[i] - A[i - 1] == d)
                i++;
            int len = i-- - start;
            if (len > 2)
                ans += (1 + len - 2) * (len - 2) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{
                1, 3, 4, 6, 7, 8, 10, 11, 12, 13
        }));
    }
}
