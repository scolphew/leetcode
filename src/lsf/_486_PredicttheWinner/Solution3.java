package lsf._486_PredicttheWinner;

public class Solution3 {
    //dp 保存得分=a-b 则正为赢，负为输
    // dp条件则    nums[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) {
            return true;
        }
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    //dp[j] 表示nums[i-j]之间的得分
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }


    public boolean foo(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) {
            return true;
        }
        int dp[][] = new int[n][n];// 表示 i,j的得分
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int tmp = j + i;
                dp[j][tmp] = Math.max(nums[tmp] - dp[j][tmp - 1], nums[j] - dp[j + 1][tmp]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new Solution3().foo(new int[]{1, 5, 2}));
    }
}
