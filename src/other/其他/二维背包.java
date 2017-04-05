package other.其他;

import java.util.Scanner;

/**
 * @author scolphew
 */
public class 二维背包 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] _01 = new int[x][2];

        for (int i = 0; i < x; i++) {
            String s = in.next();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0')
                    _01[i][0] += 1;
                else
                    _01[i][1] += 1;
            }
        }

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < x; i++) {
            for (int j = n; j >= _01[i][0]; j--) {
                for (int k = m; k >= _01[i][1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - _01[i][0]][k - _01[i][1]] + 1);
                }
            }
        }
        System.out.println(dp[n][m]);

    }
}
