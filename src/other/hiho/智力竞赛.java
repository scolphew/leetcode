package other.hiho;

import java.util.Scanner;

/**
 * 共计N个关卡。在第i个关卡中，需要获得Ai点分数才能够进入下一关。
 * 每一关的分数都是独立计算的，即使在一关当中获得超过需要的分数，也不会对后面的关卡产生影响。
 * 答对一道题获得S点分数，答错一道题获得T点分数。
 * 在所有的N个关卡中，小Hi他们一共有M次答题机会。
 * 在每个关卡中，都可以在累计答题次数不超过M的情况下使用任意次的答题机会。
 * 那么现在问题来了，对于给定的N、M、S、T和A，至少需要答对多少道题目才能够完成所有的关卡呢？
 * <p>
 * 输入
 * 第一行 Q=数据组数
 * 每组数据
 * 第一行 N M S T
 * 第二行A1 - An
 */
public class 智力竞赛 {

    static int a[] = new int[1000];
    static int[][][] dp = new int[1001][1001][2];
    static int n;
    static int m;
    static int s;
    static int t;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            n = in.nextInt();
            m = in.nextInt();
            s = in.nextInt();
            t = in.nextInt();
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int tmp = foo();
            if (tmp == -1)
                System.out.println("No");
            else
                System.out.println(tmp);
        }
    }

    public static int foo() {
        for (int i = 1; i <= m; i++) {
            if (add(dp[0][i - 1], t, dp[0][i]) == n) {
                return 0;
            }
        }
        for (int i = 1; i <= m; i++) {
            if (add(dp[i - 1][0], s, dp[i][0]) == n) {
                return i;
            }
            for (int j = 1; j <= m - i; j++) {
                if (max(dp[i - 1][j], s, dp[i][j - 1], t, dp[i][j]) == n) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int max(int[] x, int t, int[] y, int s, int[] res) {
        int x0 = x[0];
        int x1 = x[1];
        int y0 = y[0];
        int y1 = y[1];
        if (x0 == n || y0 == n) {
            res[0] = n;
            res[1] = 0;
            return n;
        }
        if (a[x0] <= x1 + t) {
            x0++;
            x1 = 0;
        } else {
            x1 += t;
        }
        if (a[y0] <= y1 + s) {
            y0++;
            y1 = 0;
        } else {
            y1 += s;
        }

        if (x0 > y0) {
            res[0] = x0;
            res[1] = x1;
        } else if (x0 == y0 && x1 > y1) {
            res[0] = x0;
            res[1] = x1;
        } else {
            res[0] = y0;
            res[1] = y1;
        }
        return res[0];

    }

    public static int add(int[] x, int y, int[] res) {
        int i = x[0];
        int j = x[1];
        if (i == n) {
            res[0] = n;
            res[1] = 0;
        } else if (a[i] <= j + y) {
            res[0] = i + 1;
            res[1] = 0;
        } else {
            res[0] = i;
            res[1] = j + y;
        }
        return res[0];
    }
}
