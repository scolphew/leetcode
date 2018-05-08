package lsf.java._540_SingleElementinaSortedArray;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if ((m & 1) == 1) m--;
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNonDuplicate(new int[]{0}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 1, 1}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 1, 1, 2, 2}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 1, 1, 2, 2, 3, 3}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 1, 1, 2, 2, 3, 3, 4, 4}));
        System.out.println(s.singleNonDuplicate(new int[]{6}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 0, 6}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 0, 1, 1, 6}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 0, 1, 1, 2, 2, 6}));
        System.out.println(s.singleNonDuplicate(new int[]{0, 0, 1, 1, 2, 2, 3, 3, 6}));
    }
}

