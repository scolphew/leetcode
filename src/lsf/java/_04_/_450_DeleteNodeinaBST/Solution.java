package lsf.java._04_._450_DeleteNodeinaBST;

import base.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode tmp = root;
        TreeNode parent = null;
        boolean isLeft = true;
        while (tmp != null && tmp.val != key) {
            parent = tmp;
            if (tmp.val > key) {
                tmp = tmp.left;
                isLeft = true;
            } else {
                tmp = tmp.right;
                isLeft = false;
            }
        }
        if (tmp != null) {
            if (parent != null) {  //删除的不是根节点
                if (tmp.left == null) {
                    if (isLeft) {
                        parent.left = tmp.right;
                    } else {
                        parent.right = tmp.right;
                    }
                    return root;
                } else if (tmp.right == null) {
                    if (isLeft) {
                        parent.left = tmp.left;
                    } else {
                        parent.right = tmp.left;
                    }
                    return root;
                }
            } else {
                if (tmp.left == null) {
                    return tmp.right;
                } else if (tmp.right == null)
                    return tmp.left;
            }
            TreeNode p = tmp;
            TreeNode c = p.left;
            while (c.right != null) {
                p = c;
                c = c.right;
            }
            tmp.val = c.val;
            if (tmp == p)
                p.left = c.left;
            else
                p.right = c.left;

        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(3);
        //t.right = new TreeNode(6);
        //t.left.left = new TreeNode(2);
        //t.left.right = new TreeNode(4);
        //t.right.right = new TreeNode(7);

        new Solution().deleteNode(t, 5);


    }
}
