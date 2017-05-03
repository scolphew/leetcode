package lsf._228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int tmp = nums[i++];
            while (i < nums.length && nums[i] - nums[i - 1] == 1) {
                ++i;
            }
            if (tmp == nums[i - 1])
                ans.add(Integer.toString(tmp));
            else
                ans.add(String.format("%d->%d", tmp, nums[i - 1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{1, 2, 3, 4, 5, 8, 9, 12, 13, 16}));
    }
}
