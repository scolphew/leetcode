package lsf._375_GuessNumberHigherorLowerII;

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n][n];
        return foo(table, 0, n - 1);
    }

    int foo(int[][] t, int start, int end) {
        if (start >= end)
            return 0;
        if (t[start][end] != 0)
            return t[start][end];
        int res = Integer.MAX_VALUE;
        for (int x = start; x <= end; x++) {
            int tmp = x + Math.max(foo(t, start, x - 1), foo(t, x + 1, end)) + 1;
            res = Math.min(res, tmp);
        }
        t[start][end] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 100; i++) {
            System.out.printf("%d %d\n", i, s.getMoneyAmount(i));
        }
    }
}
