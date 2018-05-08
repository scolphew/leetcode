package lsf.java._124_BinarTreeMaximumPathSum;

import base.TreeNode;

public class Solution {
    int maxValue = Integer.MIN_VALUE;

    /**
     * 求二叉树路径的路径和中最大的，返回最大值
     */
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(-30);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        System.out.println(s.maxPathSum(root));
    }

}
