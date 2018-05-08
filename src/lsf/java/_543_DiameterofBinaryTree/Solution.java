package lsf.java._543_DiameterofBinaryTree;

import base.TreeNode;

public class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(0);
        r.left = new TreeNode(1);
        r.right = new TreeNode(2);
        System.out.println(new Solution().maxDepth(r));
    }

}
