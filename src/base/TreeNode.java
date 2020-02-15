package base;

import java.util.List;

public class TreeNode {
    @SuppressWarnings("CanBeFinal")
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode a, TreeNode b) {
        val = x;
        left = a;
        right = b;
    }

    @Override
    public String toString() {
        return new Integer(val).toString();
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        return new lsf.java._01_._144_BinaryTreePreorderTraversal.Solution().preorderTraversal2(root);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        return new lsf.java._00_._094_BinaryTreeInorderTraversal.Solution().inorderTraversal2(root);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        return new lsf.java._01_._145_BinaryTreePostorderTraversal.Solution().postorderTraversal2(root);
    }
}
