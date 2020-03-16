package lsf.java._07_._710_RandomPickwithBlacklis;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

    Random random;
    int N;
    int l;
    Map<Integer, Integer> map;

    public Solution(int N, int[] blacklist) {
        random = new Random();
        this.N = N;
        l = N - blacklist.length;
        map = new HashMap<>();

        for (int i : blacklist) {
            map.put(i, 1);
        }
        for (int i : blacklist) {
            if (i < l) {
                N = N - 1;
                while (map.containsKey(N))
                    N -= 1;
                map.put(i, N);
            }
        }
    }

    public int pick() {
        int i = random.nextInt(l);
        return map.getOrDefault(i, i);
    }

    public static void main(String[] args) {
        Solution s = new Solution(10, new int[]{1, 3, 5,7,9});
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
    }

}
