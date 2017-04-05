package other.练习;

import java.util.Scanner;

/**
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，
 * 他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 *
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
