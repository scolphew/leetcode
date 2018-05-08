package lsf.java._357_CountNumberwithUniqueDigits;

/**
 * @author scolphew
 */
public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        int result = 1;
        int f = 9;
        for (int i = 1; i <= n; i++) {
            result += f;
            f *= 10 - i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countNumbersWithUniqueDigits(3));
    }
}
