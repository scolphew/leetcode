package lsf._310_MinimuHeightTrees;


import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        Set<Integer>[] graph = new Set[n];
        for (int i = 0; i < n; i++)
            graph[i] = new HashSet<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].isEmpty())
                return ans;
            else if (graph[i].size() == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int count = q.size();
            n -= count;
            for (int i = 0; i < count; i++) {
                int cur = q.poll();
                for (int k : graph[cur]) {
                    graph[k].remove(cur);
                    if (graph[k].size() == 1) {
                        q.offer(k);
                    }
                }
            }
        }
        ans.addAll(q);
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinHeightTrees(6, new int[][]{
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4},
        }));
    }
}
