package lsf.java._05_._575_DistributeCandies;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies)
            set.add(candy);
        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
    }

    public int function2(int[] candies) {
        int n = candies.length;
        Set<Integer> set = new HashSet<Integer>(n);
        for (int i = 0; i < n && set.size() < n / 2; i++) {
            set.add(candies[i]);
        }
        return set.size();
    }
}
