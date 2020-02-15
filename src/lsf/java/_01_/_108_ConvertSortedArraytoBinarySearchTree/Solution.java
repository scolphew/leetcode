package lsf.java._01_._108_ConvertSortedArraytoBinarySearchTree;

import base.TreeNode;

/**
 * @author scolphew
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return c_t(nums, 0, nums.length - 1);
    }

    public TreeNode c_t(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = c_t(nums, left, mid - 1);
        root.right = c_t(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortedArrayToBST(new int[]{1, 2, 3});
    }

}
