package lsf.java._154_FindMinimuminRotatedSortedArrayII;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right])
                return nums[left];

            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                left++;
                right--;
            } else {
                right = mid;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{5, 1, 1, 2, 2, 3, 3, 4, 4}));
        System.out.println(new Solution().findMin(new int[]{1, 1, 3, 1}));
        System.out.println(new Solution().findMin(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().findMin(new int[]{1, 2, 2}));
    }
}
