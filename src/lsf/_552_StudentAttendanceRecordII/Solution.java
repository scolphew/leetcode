package lsf._552_StudentAttendanceRecordII;

public class Solution {

    public static int MOD = 1000000007;

    public int sum(int[] nums) {
        long ans = 0;
        for (int n : nums) ans += n;
        return (int) (ans % MOD);
    }

    public int checkRecord(int n) {

        int dp[][] = {{1, 1, 0}, {1, 0, 0}};
        int tmp[][];

        for (int i = 2; i <= n; i++) {
            tmp = new int[][]{{0, 0, 0}, {0, 0, 0}};
            tmp[0][0] = sum(dp[0]);
            tmp[0][1] = dp[0][0];
            tmp[0][2] = dp[0][1];
            tmp[1][0] = ((sum(dp[0]) + sum(dp[1])) % MOD);
            tmp[1][1] = dp[1][0];
            tmp[1][2] = dp[1][1];
            dp = tmp;
        }
        return ((sum(dp[0]) + sum(dp[1])) % MOD);
    }
}
