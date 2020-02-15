package lsf.java._02_._268_MissingNumber;

public class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i;
            res -= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{1, 2, 3, 0}));
    }

}
