package other.hiho;


import java.util.Scanner;

/**
 * 使用n个🎲掷出总和m的概率
 */
public class 掷骰子 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        double[][] dp = new double[n + 1][m + 1];


        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j <= (i - 1) * 6; j++) {
                for (int k = 1; k < 7; k++) {
                    if (j + k <= m)
                        dp[i][j + k] += dp[i - 1][j] * 1.0 / 6;
                }
            }
        }

        System.out.println(String.format("%.2f", dp[n][m] * 100));


    }
}
