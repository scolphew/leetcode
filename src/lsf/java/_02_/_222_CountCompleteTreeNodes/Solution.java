package lsf.java._02_._222_CountCompleteTreeNodes;

import base.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = getDepth(root.left);
        int b = getDepth(root.right);

        if (a == b) {
            return (1 << a) + countNodes(root.right);
        } else
            return (1 << b) + countNodes(root.left);
    }

    int getDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            res++;
            root = root.left;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        //root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);

        System.out.println(s.countNodes(root));
        System.out.println(2 << -1);
    }
}
