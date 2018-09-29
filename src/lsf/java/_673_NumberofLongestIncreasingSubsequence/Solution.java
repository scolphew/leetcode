package lsf.java._673_NumberofLongestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N < 2) return N;
        int[] lengths = new int[N];
        //lengths[0] = 1;
        int[] counts = new int[N];
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
        }

        int longest = 0, ans = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public int insert_right(int[] nums, int l, int r, int k) {
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(s.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(s.findNumberOfLIS(new int[]{3, 1, 2}));
        System.out.println(s.findNumberOfLIS(new int[]{3, 1, 2, 2, 2, 2, 3}));
        System.out.println(s.findNumberOfLIS(new int[]{3, 1, 2, 2, 2, 2}));


        //System.out.println(s.insert_right(new int[]{1, 2, 2, 2, 3}, 0, 5, 2));
        //System.out.println(s.insert_right(new int[]{1, 3, 3, 3, 5, 5, 5}, 0, 7, 5));
    }
}
