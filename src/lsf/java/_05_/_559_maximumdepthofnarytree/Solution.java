package lsf.java._05_._559_maximumdepthofnarytree;

import base.Tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int depth = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            Queue<Node> q2 = new LinkedList<>();
            depth += 1;
            while (!q.isEmpty()) {
                Node n = q.poll();
                for (Node child : n.children) {
                    q2.offer(child);
                }
            }
            q = q2;
        }
        return depth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node root = new Node(
                3,
                Arrays.asList(
                        new Node(3, new ArrayList<>())
                )
        );
        System.out.println(s.maxDepth(root));
    }
}
