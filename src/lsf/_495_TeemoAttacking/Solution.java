package lsf._495_TeemoAttacking;

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        int ans = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] >= duration) {
                ans += duration;
            } else {
                ans += timeSeries[i] - timeSeries[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPoisonedDuration(new int[]{}, 1));
        System.out.println(new Solution().findPoisonedDuration(new int[]{1}, 2));
        System.out.println(new Solution().findPoisonedDuration(new int[]{1, 2, 3}, 2));
        System.out.println(new Solution().findPoisonedDuration(new int[]{1, 3, 5}, 2));
    }

}
