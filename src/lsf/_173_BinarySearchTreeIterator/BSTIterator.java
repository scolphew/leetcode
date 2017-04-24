package lsf._173_BinarySearchTreeIterator;

import base.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode p;
    TreeNode pre;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        p = root;
        pre = null;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty() || p != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int res;
        p = stack.pop();
        res = p.val;
        if (p.right != null) {
            p = p.right;
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
        }
        p = null;
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }

    }
}
