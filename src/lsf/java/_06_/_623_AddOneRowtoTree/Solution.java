package lsf.java._06_._623_AddOneRowtoTree;

import base.TreeNode;

public class Solution {
    /**
     * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
     * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，
     * 为 N 创建两个值为 v 的左子树和右子树。
     * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
     * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode p = new TreeNode(v);
            p.left = root;
            return p;
        }
        insert(root, d, v, 1);
        return root;
    }

    /**
     * 树有在结点root，在d-1层下面插入，结点（值为v）
     * 当前为第n层
     *
     * @param root
     * @param d
     * @param v
     * @param n
     */
    private void insert(TreeNode root, int d, int v, int n) {
        if (root == null) {
            return;
        }
        if (d == n - 1) {
            TreeNode left = root.left;
            root.left = new TreeNode(v);
            root.left.left = left;

            TreeNode right = root.right;
            root.right = new TreeNode(v);
            root.right.right = right;
        } else {
            insert(root.left, d, v, n + 1);
            insert(root.right, d, v, n + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(1)
                ),
                new TreeNode(6,
                        new TreeNode(5),
                        null
                )
        );

        Solution s = new Solution();
        s.addOneRow(root, 1, 2);
    }
}
