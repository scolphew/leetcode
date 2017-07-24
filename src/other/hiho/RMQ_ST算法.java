package other.hiho;

import java.util.Scanner;

public class RMQ_ST算法 {

    static int N;
    static int[] nums;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        nums = new int[N];
        dp = new int[N][20];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        init();
        int m = in.nextInt();
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(RMQ(a - 1, b - 1));
        }
    }


    public static int RMQ(int l, int r) {
        int k = 0;
        while ((1 << (k + 1)) <= r - l + 1) {
            k++;
        }
        return Math.min(dp[l][k], dp[r - (1 << k) + 1][k]);
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            dp[i][0] = nums[i];
        }

        for (int j = 1; (1 << j) <= N; j++) {
            for (int i = 0; i + (1 << j) - 1 < N; i++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }
    }
}
