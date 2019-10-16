package lsf.java._699_FallingSquares;

import java.util.ArrayList;
import java.util.List;


public class Solution2 {

    private static class Node {

        int l;
        int r;
        int max;
        int height;
        Node left;
        Node right;

        Node(int l, int r, int max, int height) {
            this.l = l;
            this.r = r;
            this.max = max;
            this.height = height;
        }
    }

    /**
     * 在【l,r】放一个高度为height的新盒子
     *
     * @param root
     * @param l
     * @param r
     * @param height
     * @return
     */
    private Node insert(Node root, int l, int r, int height) {
        if (root == null) {
            return new Node(l, r, r, height);
        }

        if (l <= root.l) {
            root.left = insert(root.left, l, r, height);
        } else {
            root.right = insert(root.right, l, r, height);
        }
        root.max = Math.max(r, root.max);
        return root;
    }

    /**
     * 返回 【l,r】的最高点
     */
    private int maxHeight(Node root, int l, int r) {
        if (root == null || l >= root.max) {
            return 0;
        }

        int res = 0;
        if (r > root.l && l < root.r) {   //能粘住
            res = root.height;
        }
        if (r > root.l) {
            res = Math.max(res, maxHeight(root.right, l, r));
        }
        res = Math.max(res, maxHeight(root.left, l, r));
        return res;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        /**
         * 线段树
         */
        Node root = null;
        List<Integer> res = new ArrayList<>();
        int prev = 0;

        for (int[] position : positions) {
            int l = position[0];
            int r = position[0] + position[1];
            int currentHeight = maxHeight(root, l, r);
            root = insert(root, l, r, currentHeight + position[1]);
            prev = Math.max(prev, currentHeight + position[1]);
            res.add(prev);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.fallingSquares(
                new int[][]{
                        {1, 2},
                        {2, 3},
                        {6, 1},
                        {0, 3},
                        {4, 2},
                }
        );
    }
}

