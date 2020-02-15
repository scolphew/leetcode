package lsf.java._06_._633_SumofSquareNumbers;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        while (i * i <= c / 2) {
            double res = Math.sqrt(c - i * i);
            if ((res == (int) res)) {
                System.out.println(i);
                System.out.println(res);
                return true;
            }
            i++;
        }
        return false;
    }


    public boolean a(int c) {
        // 4N+1 的素数 为 两个整数的平方和
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0) return false;
            }
        }
        return c % 4 != 3;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.judgeSquareSum(9));
        System.out.println(s.a(3 * 3 * 3 * 5));
    }

}
