package lsf._581_ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] a = Arrays.copyOf(nums, nums.length);
        Arrays.sort(a);
        int i = 0, j = nums.length - 1;
        while (i <= j && nums[i] == a[i])
            i++;
        while (i <= j && nums[j] == a[j])
            j--;
        return j - i + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{1, 2, 3, 8, 7, 5, 4, 6, 9}));
    }
}
