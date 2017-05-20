package lsf._312_BurstBalloons;

public class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int start = 0; start < n - i; start++) {
                int end = start + i;
                int t = 1;//加入数组中中a,nums[i],...,nums[j],b  t表示a*b
                if (start >= 1) t *= nums[start - 1];
                if (end + 1 < n) t *= nums[end + 1];
                //表示【start，end】之间，k是最后一个破的
                for (int k = start; k <= end; k++) {
                    int tmp = nums[k] * t;
                    if (k != start) tmp += dp[start][k - 1];
                    if (k != end) tmp += dp[k + 1][end];
                    if (tmp > dp[start][end]) dp[start][end] = tmp;
                }
                //Print.print(dp);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxCoins(new int[]{3, 1, 5, 8});
    }
}
