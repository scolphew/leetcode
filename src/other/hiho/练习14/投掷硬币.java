package other.hiho.练习14;

import java.util.Scanner;

public class 投掷硬币 {

    static int n;
    static int m;
    static double[] a = new double[1000];
    static double[][] dp = new double[1001][1001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextDouble();
        }

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - a[i - 1]);
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= m; j++) {
                dp[i][j] = dp[i - 1][j] * (1 - a[i - 1]) + dp[i - 1][j - 1] * a[i - 1];
            }
        }
        System.out.printf("%.6f\n", dp[n][m]);
    }

}
