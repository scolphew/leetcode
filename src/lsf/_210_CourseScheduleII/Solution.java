package lsf._210_CourseScheduleII;

import java.util.*;

public class Solution {
    /**
     * 拓扑排序,超时
     *
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];   //  b->a
            graph.get(b).add(a);
        }

        int n = numCourses;
        int index = numCourses - 1;
        out:
        while (n-- > 0) {
            for (int i : graph.keySet()) {
                if (graph.get(i).size() == 0) {
                    res[index--] = i;
                    graph.remove(i);
                    for (int j : graph.keySet()) {
                        if (graph.get(j).contains(i)) {
                            graph.get(j).remove(i);
                        }
                    }
                    continue out;
                }
            }
            return new int[0];
        }
        return res;
    }


    int index = 0;

    /**
     * 深度优先
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int[] flags = new int[numCourses];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, numCourses, flags, res))
                return new int[0];
        }
        return res;
    }

    public boolean dfs(List<Integer>[] graph, int i, int n, int[] flags, int[] res) {
        if (flags[i] == -1) {
            return true;
        }
        if (flags[i] == 1)
            return false;
        flags[i] = -1;
        for (int j : graph[i]) {
            if (dfs(graph, j, n, flags, res)) {
                return false;
            }
        }
        flags[i] = 1;
        res[n - index++ - 1] = i;
        return false;
    }

    public static void main(String[] args) {
        new Solution().findOrder2(4, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
        });
    }
}
