package lsf.java._05_._525_ContiguousArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                ans = Math.max(ans, i - map.get(sum));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        assert s.findMaxLength(new int[]{0, 1}) == 2;
        assert s.findMaxLength(new int[]{0, 1, 0}) == 2;
        assert s.findMaxLength(new int[]{0, 1, 0, 1}) == 4;
        assert s.findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1}) == 6;
    }

}
