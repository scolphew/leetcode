package other.其他;

import java.util.Scanner;

public class 微软1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q1 = in.nextInt();
        int n = in.nextInt();
        double res = 0;
        double q = 1.0 * q1 / 100;
        for (int i = 0; i < n; i++) {
            res += foo(p, q);
            p /= 2;
        }
        System.out.printf("%.2f", res);
    }


    public static double foo(int p1, double q) {
        double p = 1.0 * p1 / 100, res = 0, rate = 1;
        int step = 1;
        while (p < 1) {
            res += step * p * rate;
            rate *= 1 - p;
            p += q;
            step += 1;
        }
        res += step * rate;
        return res;
    }
}
