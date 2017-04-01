package other.hiho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * N M 两个正整数
 * 随机选取两个的约数N1,M1
 * 求N1=M1的概率，输出分母和分子
 */
public class 机会渺茫 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long gcd = gcd(m, n);
        long a = foo(gcd);
        long b = foo(m);
        long c = foo(n);
        long d = b * c;
        gcd = gcd(d, a);
        System.out.print(d / gcd + " " + a / gcd);
    }

    public static long foo(long a) {
        if (a == 1)
            return 1;
        long res = 1;
        long i = 2;
        Map<Long, Long> map = new HashMap<>();
        while (a > 1) {
            for (; i <= a; i++) {
                if (a % i == 0) {
                    a /= i;
                    if (map.containsKey(i)) {
                        map.put(i, map.get(i) + 1);
                    } else {
                        map.put(i, 2l);
                    }
                    break;
                }
            }
        }
        for (Long l : map.values()) {
            res *= l;
        }
        return res;
    }

    public static long gcd(long a, long b) {
        if (b > a) {
            long tmp = b;
            b = a;
            a = tmp;
        }
        long c;
        while (b != 0) {
            c = b;
            b = a % b;
            a = c;
        }
        return a;
    }
}
