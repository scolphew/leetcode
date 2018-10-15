package other.头条;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 * <p>
 * <p>
 * 输入描述:
 * 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50) 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
 * <p>
 * <p>
 * 输出描述:
 * 一个非负整数，表示该手链上有多少种颜色不符需求。
 * <p>
 * 输入例子1:
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 例子说明1:
 * 第一种颜色出现在第1颗串珠，与规则无冲突。
 * 第二种颜色分别出现在第 1，3，4颗串珠，第3颗与第4颗串珠相邻，所以不合要求。
 * 第三种颜色分别出现在第1，3，5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
 * 总计有2种颜色的分布是有问题的。
 * 这里第2颗串珠是透明的。
 */

public class 手串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();

        List<Integer>[] board = new List[c];
        for (int i = 0; i < c; i++) {
            board[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            for (int j = 0; j < num; j++) {
                int color = in.nextInt();
                board[color - 1].add(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < c; i++) {
            if (board[i].size() > 1) {
                List<Integer> tmp = board[i];
                tmp.add(tmp.get(0) + n);
                for (int j = 1; j < tmp.size(); j++) {
                    if (tmp.get(j) - tmp.get(j - 1) < m) {
                        ans += 1;
                        break;
                    }

                }
            }
        }
        System.out.println(ans);


    }
}
