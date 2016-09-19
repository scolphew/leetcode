package lsf._032_NextPermutation;

import lsf._000_base.Print;

/**
 * 一个数字数组，组成一个序列
 * 找到这些数字的组合组成的序列中，刚好比这个序列大的一个
 * 如果，当前是最大的，则返回最小的序列
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author scolphew
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        // 先找到最后一段正序的部分
        int i = nums.length - 1;
        for (; i > 0; --i)
            if (nums[i] > nums[i - 1])
                break;

        // 如果全部为倒叙，则说明原本的序列为最大序列
        if (i == 0) {
            reverse(nums, i, nums.length - 1);
            return;
        }
        // 否则，找到比nums(i-1)大的一个树
        int m = i;
        for (int j = i; j < nums.length; ++j) {
            if (nums[j] <= nums[i - 1]) {
                m = j - 1;
                break;
            } else {
                m = j;
            }
        }


        int temp = nums[i - 1];
        nums[i - 1] = nums[m];
        nums[m] = temp;

        reverse(nums, i, nums.length - 1);
    }

    /**
     * 反转数组
     */
    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] i = {1, 2};
        s.nextPermutation(i);
        Print.print(i);

        i = new int[]{1, 2, 3, 4, 3, 2, 1};
        s.nextPermutation(i);
        Print.print(i);

        i = new int[]{1, 3, 2};
        s.nextPermutation(i);
        Print.print(i);
    }
}
