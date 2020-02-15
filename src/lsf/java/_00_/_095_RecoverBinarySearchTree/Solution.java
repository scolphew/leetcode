package lsf.java._00_._095_RecoverBinarySearchTree;

import base.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树有两个位置被交换了，复原
 *
 * @author scolphew
 */
public class Solution {

    /**
     * 中序遍历，
     * 记录前一个位置比当前位置大时的前一个数字，作为第一个
     * 记录前一个数字比当前大的数字的当前数字，作为第二个，交换
     * @param root
     */
    public void recoverTree(TreeNode root) {
        boolean isFirst = true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode per = null;
        TreeNode first = null, second = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (per != null && per.val > p.val) {
                    if (isFirst) {
                        first = per;
                        isFirst = false;
                    }
                    second = p;
                }
                per = p;
                p = p.right;
            }
        }
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        s.recoverTree(root);
        lsf.java._00_._094_BinaryTreeInorderTraversal.Solution s2 = new lsf.java._00_._094_BinaryTreeInorderTraversal.Solution();
        System.out.println(s2.inorderTraversal2(root));
    }
}
