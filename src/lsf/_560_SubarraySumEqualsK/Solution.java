package lsf._560_SubarraySumEqualsK;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i : nums) {
            sum += i;
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(
                new int[]{1, 2, 2, 3, 4, 7},
                7
        ));
    }

}
