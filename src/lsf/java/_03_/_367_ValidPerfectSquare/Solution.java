package lsf.java._03_._367_ValidPerfectSquare;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return 0 == num;
    }

    public boolean f(int num) {
        double tmp = Math.sqrt(num);
        return tmp == (int) tmp;
    }
}
