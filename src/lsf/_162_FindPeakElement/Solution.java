package lsf._162_FindPeakElement;

public class Solution {
    public int findPeakElement(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        if (l + 1 == r) {
            return nums[l] > nums[r] ? l : r;
        }
        int m = (l + r) >> 1;
        if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
            return m;
        }
        if (nums[m] < nums[m - 1] && nums[m] > nums[m + 1]) {
            return findPeakElement(nums, l, m - 1);
        } else {
            return findPeakElement(nums, m + 1, r);
        }
    }

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length);
    }
}
