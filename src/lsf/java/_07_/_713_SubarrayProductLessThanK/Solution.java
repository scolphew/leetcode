package lsf.java._07_._713_SubarrayProductLessThanK;

public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2)
            return 0;
        int n = 1;
        int ans = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            n *= nums[j];    // 滑动窗口的成绩
            while (n >= k) {   //窗口左端向右，找到合适的窗口
                n /= nums[i++];
            }
            ans += j - i + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSubarrayProductLessThanK(new int[]{2, 3, 4}, 1));
    }
}
