package lsf.java._493_ReversePairs;

public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * (long) nums[j]) {
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
}
