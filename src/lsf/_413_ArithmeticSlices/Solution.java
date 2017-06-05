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

    public int foo(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{
                1, 3, 4, 6, 7, 8, 10, 11, 12, 13
        }));
    }
}
