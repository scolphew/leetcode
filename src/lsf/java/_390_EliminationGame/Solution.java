package lsf.java._390_EliminationGame;

public class Solution {
    public int lastRemaining(int n) {
        return foo(1, 1, n, true);
    }

    private int foo(int start, int d, int n, boolean l2r) {
        if (n == 1) {
            return start;
        } else {
            if (l2r) {
                return foo(start + d, 2 * d, n / 2, false);
            } else {
                return foo(start + ((n & 1) == 1 ? d : 0), 2 * d, n / 2, true);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(9));
    }
}
