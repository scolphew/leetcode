package lsf.java._589_NaryTreePreorderTraversal;

import base.Tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node p = null;

        while (!stack.isEmpty()) {
            p = stack.pop();
            list.add(p.val);
            for (int i = p.children.size() - 1; i >= 0; i--) {
                stack.add(p.children.get(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.preorder(Node.example));
    }

}
