package lsf.java._04_._486_PredicttheWinner;

public class Solution {
    int sum[];

    public boolean PredictTheWinner(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int tmp = foo(nums, 0, nums.length - 1, true);
        return tmp > sum[nums.length] - tmp;
    }

    public int foo(int[] nums, int i, int j, boolean pre) {
        if (i == j)
            return pre ? nums[i] : 0;
        if (pre) {
            int a = sum[j + 1] - sum[i] - foo(nums, i + 1, j, pre);
            int b = sum[j + 1] - sum[i] - foo(nums, i, j - 1, pre);
            return Math.max(a, b);
        } else {
            return sum[j + 1] - sum[i] - foo(nums, i, j, true);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.PredictTheWinner(
                new int[]{1, 5, 233, 7}
        ));
    }
}
