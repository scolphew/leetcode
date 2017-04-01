package other;

import java.util.Scanner;

/**
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
