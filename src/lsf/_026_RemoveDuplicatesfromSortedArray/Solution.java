package lsf._026_RemoveDuplicatesfromSortedArray;

/**
 * 排好序的,数组去重
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        int k = s.removeDuplicates(nums);
        System.out.println(k);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }
}
