package lsf._473_MatchstickstoSquare;

import java.util.Arrays;

public class Solution {

    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 4 != 0)
            return false;
        Arrays.sort(nums);
        return helper(nums, nums.length - 1, new int[4], sum / 4);
    }

    boolean helper(int[] nums, int index, int[] sum, int goal) {
        if (index < 0) {
            return sum[0] == goal && sum[1] == goal && sum[2] == goal;
        }
        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[index] > goal) continue;
            sum[i] += nums[index];
            if (helper(nums, index - 1, sum, goal)) return true;
            sum[i] -= nums[index];
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().makesquare(new int[]{1, 1, 2, 2, 2}));
    }

}
