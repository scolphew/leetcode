package lsf.java._697_DegreeofanArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> n = new HashMap<>();
        Map<Integer, Integer> f = new HashMap<>();
        Map<Integer, Integer> e = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            n.put(nums[i], n.getOrDefault(nums[i], 0) + 1);
            f.putIfAbsent(nums[i], i);
            e.put(nums[i], i);
        }
        int a = Integer.MAX_VALUE, b = 0;
        for (Map.Entry<Integer, Integer> entry : n.entrySet()) {
            int x = entry.getValue();
            int y = e.get(entry.getKey()) - f.get(entry.getKey()) + 1;
            if ((x > b) || (x == b && y < a)) {
                a = y;
                b = x;
            }
        }
        return a;
    }


    public int findShortestSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums)
            max = Math.max(max, i);

        int[] bucket = new int[max + 1];
        int[] firstIndex = new int[max + 1];
        int[] lastIndex = new int[max + 1];
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;

            if (bucket[nums[i]] == 1) {
                firstIndex[nums[i]] = i;
                lastIndex[nums[i]] = i;
            } else {
                lastIndex[nums[i]] = i;
            }
            degree = Math.max(degree, bucket[nums[i]]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == degree) {
                res = Math.min(lastIndex[i] - firstIndex[i] + 1, res);
            }
        }
        return res;
    }

    public int findShortestSubArray3(int[] nums) {
        Map<Integer, int[]> map = new HashMap();
        int freq = 0, min = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            int[] tmp = null;
            if (!map.containsKey(nums[i])) {
                tmp = new int[2];
                tmp[1] = i;
                map.put(nums[i], tmp);
            } else {
                tmp = map.get(nums[i]);
            }
            if (++tmp[0] > freq ||
                    (tmp[0] == freq && min > i - tmp[1] + 1)) {
                min = i - tmp[1] + 1;
                freq = tmp[0];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));

    }

}
