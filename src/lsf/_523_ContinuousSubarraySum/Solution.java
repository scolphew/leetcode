package lsf._523_ContinuousSubarraySum;

import java.util.HashMap;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return false;
        if (k == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        if (k == 1) {
            return true;
        }

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer prev = map.get(sum % k);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(sum % k, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkSubarraySum(new int[]{2, 6, 1}, 6));
    }
}
