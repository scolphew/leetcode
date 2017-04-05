package other.hiho.练习;

import java.util.Scanner;

/**
 * @author scolphew
 */
public class 哥德巴赫猜想 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 2; i <= n; i++) {
            if (foo(i) && foo(n - i)) {
                System.out.println(i + " " + (n - i));
                break;
            }
        }
    }

    public static boolean foo(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

}
