package lsf.java._440_KthSmallestinLexicographicalOrder;

public class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int step = foo(n, curr);
            if (step <= k) {
                k -= step;
                curr++;
            } else {
                k--;
                curr *= 10;
            }
        }
        return curr;
    }

    private int foo(int n, long a) {
        int step = 0;
        int num = 1;
        while (a < n) {
            step += Math.min(n + 1 - a, num);
            a *= 10;
            num *= 10;
        }
        return step;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(681692778, 351251360));
        System.out.println(new Solution().findKthNumber(10, 3));
        new Solution().foo(123, 1);
        System.out.println(Integer.MAX_VALUE);
    }
}
