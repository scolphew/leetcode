package lsf._173_BinarySearchTreeIterator;

import base.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode p = stack.pop();
        pushAll(p.right);
        return p.val;
    }

    public void pushAll(TreeNode n) {
        while (n != null) {
            stack.add(n);
            n = n.left;
        }
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
