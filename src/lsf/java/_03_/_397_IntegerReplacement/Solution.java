package lsf.java._03_._397_IntegerReplacement;

public class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else {
                if ((n + 1) % 4 == 0 && n != 3)
                    n++;
                else
                    n--;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerReplacement(3));
        System.out.println(new Solution().integerReplacement(2147483647));
    }
}
