package lsf.java._06_._667_BeautifulArrangementII;

import base.Print;

public class Solution {

    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n - k; i++) {
            nums[i] = i + 1;
        }
        for (int i = n - k + 1, j = n - k + 1; i < n; i += 2, j++) {
            nums[i] = j;
        }
        for (int i = n - k, j = n; i < n; i += 2, j--) {
            nums[i] = j;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Print.print(s.constructArray(9, 5));
        Print.print(s.constructArray(9, 4));
    }

}
