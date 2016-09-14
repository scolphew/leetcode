package lsf._029_DivideTwoIntegers;

/**
 * @author scolphew
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;

        x = (x < 0) ? -x : x;
        y = (y < 0) ? -y : y;
        int power = 31;

        long yPower = y << power;
        long result = 0;

        while (x >= y) {
            while (yPower > x) {
                yPower >>= 1;
                power--;
            }
            x -= yPower;
            result += (1l << power);
        }
        result = (dividend > 0) ^ (divisor > 0) ? -result : result;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(Integer.MIN_VALUE, -1));
    }
}
