package other;

import java.util.Scanner;

/**
 * @author scolphew
 */
public class 序列和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        for (int i = l; i <= 100 && n >= (i * i + i) / 2; i++) {
            if ((2 * n + i - i * i) % (2 * i) == 0) {
                int start = (2 * n + i - i * i) / (2 * i);
                if (start >= 0) {
                    for (int j = 0; j < i - 1; j++) {
                        System.out.print(j + start);
                        System.out.print(" ");
                    }
                    System.out.println(start + i - 1);
                    return;
                }
            }
        }
        System.out.println("No");
    }
}
