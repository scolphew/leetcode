package base;

public class Base {

    public static int gcd(int a, int b) {
        while (b != 1) {
            if (a % b == 0) return b;
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    public static int gcd2(int a, int b) {
        if (a == 0) return b;
        if(b==0) return  a;
        return gcd(a,b);
    }
}
