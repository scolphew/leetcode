package lsf._133_CloneGraph;

import java.util.*;

public class Solution {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }


    /*BFS*/
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return node;

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);

        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(root.label, root);

        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            UndirectedGraphNode p = q.poll();
            for (UndirectedGraphNode v : p.neighbors) {
                if (!map.containsKey(v.label)) {
                    map.put(v.label, new UndirectedGraphNode(v.label));
                    q.add(v);
                }
                map.get(p.label).neighbors.add(map.get(v.label));
            }
        }
        return root;
    }

    /*DFS*/
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null)
            return null;

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, root);

        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            UndirectedGraphNode n = stack.pop();
            for (UndirectedGraphNode v : n.neighbors) {
                if (!map.containsKey(v)) {
                    map.put(v, new UndirectedGraphNode(v.label));
                    stack.push(v);
                }
                map.get(n).neighbors.add(map.get(v));
            }
        }
        return root;
    }
}
