package lsf._398_RandomPickIndex;

import java.util.*;

public class Solution {
    HashMap<Integer, List<Integer>> map;
    Random r = new Random();

    public Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>() {
            @Override
            public List<Integer> get(Object key) {
                if (!containsKey(key))
                    put((int) key, new ArrayList<>());
                return super.get(key);
            }
        };
        for (int i = 0; i < nums.length; i++) {
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int size = list.size();
        int tmp = r.nextInt(size);
        return list.get(tmp);
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1, 1, 1, 3, 3});
        System.out.println(s.pick(1));
        System.out.println(s.pick(1));
        System.out.println(s.pick(1));
        System.out.println(s.pick(1));
        System.out.println(s.pick(1));
        System.out.println(s.pick(3));
        System.out.println(s.pick(3));
        System.out.println(s.pick(3));
        System.out.println(s.pick(3));
    }

}
