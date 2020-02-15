package lsf.java._06_._662_MaximumWidthofBinaryTree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class X {
        TreeNode node;
        int d;
        int i;

        public X(TreeNode n, int a, int b) {
            node = n;
            d = a;
            i = b;
        }

        @Override
        public String toString() {
            return node.val + ",(" + d + ")";
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<X> q = new LinkedList<>();
        q.offer(new X(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!q.isEmpty()) {
            X p = q.poll();
            if (p.node != null) {
                q.add(new X(p.node.left, p.d + 1, p.i * 2));
                q.add(new X(p.node.right, p.d + 1, p.i * 2 + 1));

                if (curDepth != p.d) {
                    curDepth++;
                    left = p.i;
                }
                ans = Math.max(ans, p.i - left + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        Solution s = new Solution();
        System.out.println(s.widthOfBinaryTree(t));
    }

}

