package lsf._207_CourseSchedule;

import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, numCourses, flags))
                return false;
        }
        return true;
    }

    public boolean dfs(List<Integer>[] graph, int i, int n, int[] flags) {
        if (flags[i] == -1) {
            return true;
        }
        if (flags[i] == 1)
            return false;
        flags[i] = -1;
        for (int j : graph[i]) {
            if (dfs(graph, j, n, flags))
                return true;
        }
        flags[i] = 1;
        return false;
    }
}
