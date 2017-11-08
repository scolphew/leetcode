package lsf.java._451_SortCharactersByFrequency;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            q.offer(entry);
        }

        while (!q.isEmpty()) {
            Map.Entry<Character, Integer> entry = q.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("Aabb"));
    }

}
