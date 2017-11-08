package lsf.java._390_EliminationGame;

public class Solution2 {
    public int lastRemaining(int n) {
        if (n <= 1) return n;

        boolean left = true;
        int step = 1;
        int head = 1;

        int remaining = n;
        while (remaining > 1) {
            if (left || (remaining & 1) == 1) {  //从左向右，或者从右向左但是有奇数个
                head += step;
            }
            remaining /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}
