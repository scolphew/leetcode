package lsf.java._117_PopulatingNextRightPointersinEachNodeII;

public class Solution {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode pre = root;
        TreeLinkNode cur, first;
        while (pre != null) {

            while (pre != null && pre.left == null && pre.right == null) {
                pre = pre.next;
            }
            if (pre == null)
                return;

            cur = new TreeLinkNode(0);
            first = cur;
            while (pre != null) {
                if (pre.left != null) {
                    cur.next = pre.left;
                    cur = cur.next;
                }
                if (pre.right != null) {
                    cur.next = pre.right;
                    cur = cur.next;
                }
                pre = pre.next;
            }
            pre = first.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeLinkNode root = new TreeLinkNode(0);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(4);
        root.left.left = new TreeLinkNode(1);
        root.left.left.left = new TreeLinkNode(5);
        root.left.left.right = new TreeLinkNode(1);

        root.right.left = new TreeLinkNode(3);
        root.right.left.right = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(-1);
        root.right.right.right = new TreeLinkNode(8);
        s.connect(root);
    }

}
