package lsf.java._05_._582_KillProcess;

import java.util.*;

public class Solution3 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new LinkedList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(kill);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            res.add(cur);
            List<Integer> adjacencyList = map.get(cur);
            if (adjacencyList == null)
                continue;
            stack.addAll(adjacencyList);
        }
        return res;
    }
}
