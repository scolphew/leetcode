package lsf.java._257_BinaryTreePaths;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root, pre = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p.right != null && p.right != pre) {
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                } else {
                    if (p.left == null && p.right == null) {
                        foo(ans, stack);
                    }
                    stack.pop();
                    pre = p;
                    p = null;
                }
            }
        }
        return ans;
    }

    private void foo(List<String> ans, Stack<TreeNode> stack) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode treeNode : stack) {
            sb.append(treeNode.val + "->");
        }
        sb.delete(sb.length() - 2, sb.length());
        ans.add(sb.toString());
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode r = new TreeNode(2, a, b);

        System.out.println(new Solution().binaryTreePaths(r));

    }
}
