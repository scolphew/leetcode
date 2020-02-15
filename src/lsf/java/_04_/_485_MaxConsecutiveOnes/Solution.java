package lsf.java._04_._485_MaxConsecutiveOnes;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            while (i < nums.length && nums[i] == 1) {
                tmp++;
                i++;
            }
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

}
