package lsf.java._633_SumofSquareNumbers;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        while (i * i <= c / 2) {
            double res = Math.sqrt(c - i * i);
            if ((res == (int) res))
                return true;
            i++;
        }
        return false;
    }

}
