package lsf.java._04_._494_TargetSum;

public class Solution {

    int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, 0, nums, S);
        return ans;
    }

    private void dfs(int sum, int cut, int[] nums, int S) {
        if (cut == nums.length) {
            if (sum == S)
                ans++;
            return;
        }
        dfs(sum + nums[cut], cut + 1, nums, S);
        dfs(sum - nums[cut], cut + 1, nums, S);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}
