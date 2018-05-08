package lsf.java._475_Heaters;

import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0; i < houses.length; i++) {
            int index = Arrays.binarySearch(heaters, houses[i]);
            if (index < 0) {
                index = ~index;
                int dist1 = index >= 1 ? houses[i] - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - houses[i] : Integer.MAX_VALUE;
                ans = Math.max(ans, Math.min(dist1, dist2));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRadius(new int[]{1, 2, 3}, new int[]{1}));
    }

}
