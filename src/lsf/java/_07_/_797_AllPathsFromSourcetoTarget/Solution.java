package lsf.java._07_._797_AllPathsFromSourcetoTarget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int node : graph[x]) {
            stack.addLast(node);
            dfs(graph, node, n);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> lists = s.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        System.out.println(lists);
    }
}
