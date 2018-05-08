package lsf.java._016_3SumClosest;

import java.util.Arrays;

/**
 * 数组中三个数之和最接近target的三个数的和
 * @author scolphew
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 4)
            return nums[0] + nums[1] + nums[2];
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[right] + nums[left] == target) {
                    return target;
                } else if (nums[i] + nums[right] + nums[left] > target) {
                    while (left < right && nums[i] + nums[left] + nums[right] > target)
                        right--;
                    if (Math.abs(target - closest) > Math.abs(nums[i] + nums[right + 1] + nums[left] - target))
                        closest = nums[i] + nums[right + 1] + nums[left];
                } else if (nums[i] + nums[right] + nums[left] < target) {
                    while (left < right && nums[i] + nums[left] + nums[right] < target)
                        left++;
                    if (Math.abs(target - closest) > Math.abs(nums[i] + nums[right] + nums[left - 1] - target))
                        closest = nums[i] + nums[right] + nums[left - 1];
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        System.out.println(i);
    }
}
