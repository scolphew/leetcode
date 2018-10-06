package lsf.java._655_PrintBinaryTree;

import base.TreeNode;

import java.util.*;

public class Solution {
    class P {
        TreeNode node;
        int index;
        int level;

        public P(TreeNode p, int x, int y) {
            node = p;
            index = x;
            level = y;
        }

        @Override
        public String toString() {
            return "" + node.val + "(" + level + "," + index + ")";
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        List<List<String>> list = new ArrayList<>();
        String[][] strings = new String[h][(1 << h) - 1];
        for (String[] ss : strings)
            Arrays.fill(ss, "");
        int mid = (1 << (h - 1)) - 1;
        p(strings, root, 1, mid, 1 << (h - 2));
        for (String[] ss : strings)
            list.add(Arrays.asList(ss));
        return list;
    }

    void p(String[][] strings, TreeNode node, int level, int index, int diff) {
        if (node == null)
            return;
        strings[level - 1][index] = "" + node.val;
        if (node.left != null)
            p(strings, node.left, level + 1, index - diff, diff / 2);
        if (node.right != null)
            p(strings, node.right, level + 1, index + diff, diff / 2);
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.printTree(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(4),
                                        null),
                                null
                        ),
                        new TreeNode(5)
                )
        ));
    }
}
