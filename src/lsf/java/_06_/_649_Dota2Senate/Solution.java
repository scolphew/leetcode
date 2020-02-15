package lsf.java._06_._649_Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> queue = new LinkedList();
        int[] people = new int[]{0, 0};
        int[] bans = new int[]{0, 0};

        for (char person : senate.toCharArray()) {
            int x = person == 'R' ? 1 : 0;
            people[x]++;
            queue.add(x);
        }

        while (people[0] > 0 && people[1] > 0) {
            int x = queue.poll();
            if (bans[x] > 0) {
                bans[x]--;
                people[x]--;
            } else {
                bans[x ^ 1]++;
                queue.add(x);
            }
        }

        return people[1] > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.predictPartyVictory("RDD");
    }
}
