package lsf._575_DistributeCandies;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies)
            set.add(candy);
        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
    }
}
