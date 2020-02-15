package lsf.java._05_._563_BinaryTreeTilt;

import base.TreeNode;

public class Solution {
    int ans = 0;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return ans;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }

}
