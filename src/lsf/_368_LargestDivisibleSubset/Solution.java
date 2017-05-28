package lsf._368_LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int counts[] = new int[nums.length];
        int lastIndexes[] = new int[nums.length];
        counts[0] = 1;
        lastIndexes[0] = -1;
        int end = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int count = 0;
            int lastIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && counts[j] > count) {
                    count = counts[j];
                    lastIndex = j;
                }
            }
            counts[i] = count + 1;
            lastIndexes[i] = lastIndex;
            if (counts[i] > max) {
                max = counts[i];
                end = i;
            }
        }
        List<Integer> list = new ArrayList<>(max);
        while (end != -1) {
            list.add(nums[end]);
            end = lastIndexes[end];
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{2, 3, 6, 12, 18, 24}));
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1}));
    }
}
