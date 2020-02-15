package lsf.java._02_._213_HouseRobberII;


public class Solution {
    public int rob(int[] nums, int l, int r) {
        int a = 0, b = 0;
        for (int i = l; i <= r; i++) {
            int tmp = b;
            if (a + nums[i] > b)
                b = a + nums[i];
            a = tmp;
        }
        return b;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 5, 4}));
        System.out.println(new Solution().rob(new int[]{1, 1, 1, 2}));
        System.out.println(new Solution().rob(new int[]{2}));
        System.out.println(new Solution().rob(new int[]{2, 5}));

    }
}
