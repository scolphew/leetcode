package lsf.java._582_KillProcess;


import java.util.*;

public class Solution2 {

    class Tree {
        int pid;
        List<Tree> children;

        Tree(int i) {
            pid = i;
            children = new ArrayList<>();
        }
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Tree> map = new HashMap<>();
        map.put(0, new Tree(0));
        for (int i : pid) {
            map.put(i, new Tree(i));
        }
        for (int i = 0; i < pid.size(); i++) {
            map.get(ppid.get(i)).children.add(map.get(pid.get(i)));
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Tree> q = new LinkedList<>();
        q.add(map.get(kill));
        while (!q.isEmpty()) {
            Tree tmp = q.poll();
            ans.add(tmp.pid);
            for (Tree t : tmp.children) {
                q.add(t);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<Integer> a = new ArrayList<>();
        for (int i : new int[]{1, 3, 10, 5}) {
            a.add(i);
        }
        List<Integer> b = new ArrayList<>();
        for (int i : new int[]{3, 0, 5, 3}) {
            b.add(i);
        }
        System.out.println(s.killProcess(a, b, 5));
    }

}
