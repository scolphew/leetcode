package lsf.java._347_TopKFrequentElements;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(entry);
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(q.poll().getKey());
        }
        return ans;
    }


    /**
     * 有点问题，能AC
     * 如：[1,1,1,2,3,2,3] k=2
            返回【1，2,3】
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        // put inside map
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // check
        for (int key : map.keySet()) {
            int f = map.get(key); // frequency
            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }

            bucket[f].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res;
    }


}
