package lsf._332_ReconstructItinerary;

import java.util.*;

public class Solution {


    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        for (String[] ticket : tickets) {
            g.putIfAbsent(ticket[0], new PriorityQueue());
            g.get(ticket[0]).offer(ticket[1]);
        }
        LinkedList<String> ans = new LinkedList<>();
        foo(ans, g, "1");
        return ans;
    }

    public void foo(LinkedList<String> ans, Map<String, PriorityQueue<String>> g, String s) {
        PriorityQueue<String> to = g.get(s);
        while (to != null && !to.isEmpty()) {
            foo(ans, g, to.poll());
        }
        ans.addFirst(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findItinerary(
                new String[][]{
                        {"1", "2"},
                        {"1", "3"},
                        {"1", "4"},
                        {"4", "5"},
                        {"5", "3"},
                        {"3", "2"},
                }
        ));
    }
}
