package lsf.java._582_KillProcess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * TLE
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            ans.add(tmp);
            for (int i = 0; i < pid.size(); i++) {
                if (ppid.get(i) == tmp) {
                    queue.add(pid.get(i));
                }
            }
        }
        return ans;
    }

}
