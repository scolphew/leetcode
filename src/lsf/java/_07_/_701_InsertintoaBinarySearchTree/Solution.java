package lsf.java._07_._701_InsertintoaBinarySearchTree;

import base.TreeNode;

public class Solution {

    /**
     * BST插入
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode p = root;
        TreeNode node = new TreeNode(val);
        while (p != null) {
            if (p.val > val) {                   //应往左孩子插入
                if (p.left == null) {            //做子树为空，直接插入
                    p.left = node;
                    return root;
                } else {                            //左孩子非空，继续迭代
                    p = p.left;
                }
            } else {                                 //应往右孩子插入
                if (p.right == null) {              //右子树为空，直接插入
                    p.right = node;
                    return root;
                } else {
                    p = p.right;              //右子树非空，继续迭代
                }
            }
        }
        return node;
    }

}
