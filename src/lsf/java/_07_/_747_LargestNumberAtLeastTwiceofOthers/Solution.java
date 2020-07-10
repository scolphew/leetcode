package lsf.java._07_._747_LargestNumberAtLeastTwiceofOthers;

public class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0, second = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                second = max;
                max = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return 2 * second <= max ? index : -1;
    }
}
