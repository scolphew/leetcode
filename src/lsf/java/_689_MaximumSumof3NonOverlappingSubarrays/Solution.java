package lsf.java._689_MaximumSumof3NonOverlappingSubarrays;

import base.Print;

public class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int l = n - k + 1;

        int maxSum = 0;
        int[] ans = new int[3];

        int[] sums = new int[l]; //从i位开始，长度为k的数组的最大值
        int[][] maxSumL = new int[l][2]; // 0~i-1起点 长度为k的k子数组和最大值,和起始位置
        int[][] maxSumR = new int[l][2]; // i~n-1 k子数组最大值

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        sums[0] = sum;
        for (int i = k; i < n; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            sums[i - k + 1] = sum;
        }


        int maxL = 0, maxLIndex = 0;
        for (int i = 0; i < l; i++) {
            if (sums[i] > maxL) {
                maxL = sums[i];
                maxLIndex = i;
            }
            maxSumL[i][0] = maxL;
            maxSumL[i][1] = maxLIndex;
        }

        int maxR = 0, maxRIndex = l - 1;
        for (int i = l - 1; i >= 0; i--) {
            if (sums[i] > maxR) {
                maxR = sums[i];
                maxRIndex = i;
            }
            maxSumR[i][0] = maxR;
            maxSumR[i][1] = maxRIndex;
        }

        for (int i = k; i < l - k; i++) {
            maxL = maxSumL[i - k][0];
            maxLIndex = maxSumL[i - k][1];

            maxR = maxSumR[i + k][0];
            maxRIndex = maxSumR[i + k][1];

            int max = sums[i] + maxL + maxR;
            if (max > maxSum) {
                ans[0] = maxLIndex;
                ans[1] = i;
                ans[2] = maxRIndex;
                maxSum = max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Print.print(s.maxSumOfThreeSubarrays(
                new int[]{1, 2, 1, 2, 6, 7, 5, 1},
                2
        ));
    }

}
