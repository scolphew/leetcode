package lsf._236_LowestCommonAncestorofaBinaryTree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.List;

public class Solution {
    /**
     * LCA
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> l1 = null;
        List<TreeNode> l2 = null;
        TreeNode tmp = root, pre = null;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = stack.peek();
                if (tmp.right != null && tmp.right != pre) {
                    tmp = tmp.right;
                    stack.push(tmp);
                    tmp = tmp.left;
                } else {
                    if (tmp == p || tmp == q) {
                        if (l1 == null) {
                            l1 = new ArrayList<>(stack);
                        } else {
                            l2 = new ArrayList<>(stack);
                            break;
                        }
                    }
                    stack.pop();
                    pre = tmp;
                    tmp = null;
                }
            }
        }
        Iterator<TreeNode> iterator1 = l1.iterator();
        Iterator<TreeNode> iterator2 = l2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if ((p = iterator1.next()) == iterator2.next())
                root = p;
            else
                break;
        }
        return root;
    }

    /**
     * 递归
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root : left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);

        TreeNode t = new TreeNode(0, a, null);

        System.out.println(new Solution().lowestCommonAncestor(t, a, t));
    }
}
