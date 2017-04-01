package other;

import java.util.Scanner;

public class 页码统计 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < 9; i++) {
            System.out.print(countN(n, i));
            System.out.print(" ");
        }
        System.out.print(countN(n, 9));
        countN(99, 7);
    }

    public static int countN(int n, int x) {
        int count = 0, j = n, i = 1;
        while (j != 0) {
            int high = j / 10;
            if (x == 0) {
                if (high != 0)
                    high--;
                else
                    break;
            }
            count += high * i;
            int tem = j % 10;
            if (tem > x)
                count += i;
            else if (tem == x)
                count += n - j * i + 1;
            i *= 10;
            j = n / i;
        }
        return count;

    }
}