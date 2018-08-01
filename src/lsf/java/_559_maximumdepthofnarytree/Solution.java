package lsf.java._559_maximumdepthofnarytree;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

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
