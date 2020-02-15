package lsf.java._06_._654_MaximumBinaryTree;

import base.TreeNode;

public class Solution {

    /**
     * 最大二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_index = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = construct(nums, l, max_index);
        root.right = construct(nums, max_index + 1, r);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int max_index = l;
        for (int i = l; i < r; i++) {
            if (nums[max_index] < nums[i])
                max_index = i;
        }
        return max_index;
    }

}
