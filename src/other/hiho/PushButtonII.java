package other.hiho;

import java.util.Scanner;

/**
 * There are N buttons on the console. Each button needs to be pushed exactly once.
 * Each time you may push several buttons simultaneously.
 * Assume there are 4 buttons. You can first push button 1 and button 3 at one time,
 * then push button 2 and button 4 at one time. It can be represented as a string "13-24".
 * Other pushing way may be "1-2-4-3", "23-14" or "1234". Note that "23-41" is the same as "23-14".
 * Given the number N your task is to find the number of different valid pushing ways.
 * <p>
 * n个不同数字，每次挑选任意个，知道调完，有多少种方法。
 * f(i,j)表示，1-i的数字分j组挑选
 * f(x,1)=1  f(x,x)=x!
 * f(x,j)=f(x-1,j)*j + f(x-1,j-1)*j
 * 将x分为j组，等于：
 * 1.将x-1分为j组，在任意组加上j
 * 2.将x-1分为j-1组，在任意两组之间插入j
 */

public class PushButtonII {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int M = 1000000007;

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] * (j + 1) % M;
                dp[i][j] += dp[i - 1][j - 1] * (j + 1) % M;
                dp[i][j] %= M;
            }
            dp[i][i] = dp[i - 1][i - 1] * (i + 1) % M;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[n - 1][i] % M;
            ans %= M;
        }
        System.out.println(ans % M);
    }

}
