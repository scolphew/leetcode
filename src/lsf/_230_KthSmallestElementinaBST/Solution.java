package lsf._230_KthSmallestElementinaBST;

import base.TreeNode;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        int i = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (++i == k) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        t.right = new TreeNode(5);

        System.out.println(new Solution().kthSmallest(t, 2));

    }
}
