package other.练习;

import java.util.Scanner;

/**
 * 如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,
 * q为大于1的正整数就称这个数叫做超级素数幂。
 * 现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。
 *
 * @author scolphew
 */
public class 超级素数幂 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        int q;
        double p;
        for (q = 2; q * q <= l; q++) {
            p = Math.pow(l, 1.0 / q);
            if (p == (int) p && is((int) p)) {
                System.out.println((int) p + " " + q);
                return;
            }
        }
        System.out.println("No");
    }

    public static boolean is(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
